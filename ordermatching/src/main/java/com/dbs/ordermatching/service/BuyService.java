package com.dbs.ordermatching.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.secure.internal.DisabledJaccServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.ordermatching.model.Buy;
import com.dbs.ordermatching.model.Client;
import com.dbs.ordermatching.model.Sell;
import com.dbs.ordermatching.repo.BuyRepository;
import com.dbs.ordermatching.repo.SellRepository;
@Service
public class BuyService {
	@Autowired
	private BuyRepository brepo;
	@Autowired
	private SellRepository srepo;
	@Autowired
	private ClientService cservice;
	@Autowired
	private ClientInstrumentService ciservice;
	@Autowired
	private TradeHistoryService thservice;
	public int insertSBuy(String cid,String iid, Double p, Integer q) throws Exception {
		int bid=(int)this.brepo.count()+1;
		Client client=cservice.findClientById(cid);
		if(client.getTransactionLimit()<(p*q) || client.getBalance()<(p*q))
			return -1;
		this.brepo.insertBuy(bid,cid, iid, p, q);
		
		client.setTransactionLimit(client.getTransactionLimit()-(p*q));
		cservice.updateClient(client);
		List<Integer> list= this.brepo.bOrderMatching(iid, p);
		Buy b=this.brepo.findById(bid).get();
		List<Integer> l=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			Sell s= this.srepo.findById(list.get(i)).get();
			if(!s.getClient().getCustodian().getCustodianId().equals(b.getClient().getCustodian().getCustodianId())) {
				l.add(list.get(i));
			}
			//System.out.print( s.getClient().getCustodian().getCustodianId()+"=="+b.getClient().getCustodian().getCustodianId());
		}
		int quan=q;
		System.out.println("List"+l);
		//System.out.println(bid);
		
		System.out.println("buy test" + b);
		while(quan>0 && l.size()>0) {
			Sell s= this.srepo.findById(l.get(0)).get();
			
			if(s.getRemainingQty()>=b.getRemainingQty()) {
				Client sClient=s.getClient();
				sClient.setBalance(sClient.getBalance()+(b.getRemainingQty()*p));
				s.setRemainingQty(s.getRemainingQty()-b.getRemainingQty());
				int squant=s.getRemainingQty();
				Client bClient= b.getClient();
				bClient.setBalance(bClient.getBalance()-(b.getRemainingQty()*p));
				cservice.updateClient(bClient);
				cservice.updateClient(sClient);
				b.setRemainingQty(0);//50 25 
				
				
				b.setFlag(0);
				if(s.getRemainingQty()==0)
				{
					s.setFlag(0);
					ciservice.insertClientInstrument(s.getClient().getClientId(), s.getInstrument().getInstrumentId(), quan, 'S');
				}
				else {
					ciservice.insertClientInstrument(s.getClient().getClientId(), s.getInstrument().getInstrumentId(), quan, 'S');
				}
				ciservice.insertClientInstrument(b.getClient().getClientId(), iid, quan, 'B');
				thservice.insertTradeHistory(bid, l.get(0), iid, p, quan);
				quan=0;
			}
			else {//buyer>seller
				Client sClient=s.getClient();
				sClient.setBalance(sClient.getBalance()+(s.getRemainingQty()*p));
				Client bClient= b.getClient();
				bClient.setBalance(bClient.getBalance()-(s.getRemainingQty()*p));
				
				b.setRemainingQty(b.getRemainingQty()-s.getRemainingQty());
				int squant=s.getRemainingQty();
				quan=quan-squant;
				cservice.updateClient(bClient);
				cservice.updateClient(sClient);
				s.setRemainingQty(0);
				s.setFlag(0);
				ciservice.insertClientInstrument(s.getClient().getClientId(), iid, squant, 'S');
				ciservice.insertClientInstrument(b.getClient().getClientId(), iid, squant, 'B');
				thservice.insertTradeHistory(bid, l.get(0), iid, p, squant);
				
			}
			brepo.save(b);
			srepo.save(s);
			l.remove(0);
		}
		return bid;
	}
	
	public List<Buy> getBuy(){
		List<Buy> b=new ArrayList<>();
		 this.brepo.findAll().forEach(ele->b.add(ele));
		 return b;
	}
	public Buy findById(int bid) {
		try {
			Optional<Buy> c=this.brepo.findById(bid);
			return c.orElseThrow(()->{
				return new EntityNotFoundException("Buy with "+bid + " does not exist");
			});
			}
		catch(IllegalArgumentException iae) {
			return null;
		}
	}
	
	
}
