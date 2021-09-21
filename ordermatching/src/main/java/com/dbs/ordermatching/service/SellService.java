package com.dbs.ordermatching.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.ordermatching.model.Buy;
import com.dbs.ordermatching.model.Client;
import com.dbs.ordermatching.model.Sell;
import com.dbs.ordermatching.repo.BuyRepository;
import com.dbs.ordermatching.repo.SellRepository;

@Service
public class SellService {
	
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

	public int insertSSell(String cid,String iid, Double p, Integer q) throws Exception {
		int sid=(int)this.srepo.count()+1;
		Client client=cservice.findClientById(cid);
		if(client.getTransactionLimit()<(p*q))
			return -1;
		this.srepo.insertSell(sid,cid, iid, p, q);
		client.setTransactionLimit(client.getTransactionLimit()-(p*q));
		cservice.updateClient(client);
		List<Integer> list= this.srepo.sOrderMatching(iid, p);
		Sell s=this.srepo.findById(sid).get();
		List<Integer> l=new ArrayList<>();
		
		for(int i=0;i<list.size();i++){
			Buy b= this.brepo.findById(list.get(i)).get();
			if(!s.getClient().getCustodian().getCustodianId().equals(b.getClient().getCustodian().getCustodianId())) {
				l.add(list.get(i));
			}
			//System.out.print( s.getClient().getCustodian().getCustodianId()+"=="+b.getClient().getCustodian().getCustodianId());
		}
		int quan=q;
		
		//System.out.println(bid);
		
		System.out.println("sell test" + s);
		while(quan>0 && l.size()>0) {
			Buy b= this.brepo.findById(l.get(0)).get();
			if(b.getRemainingQty()>=s.getRemainingQty()) {
				Client bClient=b.getClient();
				bClient.setBalance(bClient.getBalance()-(s.getRemainingQty()*p));
				b.setRemainingQty(b.getRemainingQty()-s.getRemainingQty());
				int bquant=b.getRemainingQty();
				Client sClient= s.getClient();
				sClient.setBalance(sClient.getBalance()+(s.getRemainingQty()*p));
				cservice.updateClient(bClient);
				cservice.updateClient(sClient);
				s.setRemainingQty(0);
				s.setFlag(0);
				if(b.getRemainingQty()==0)
				{
					b.setFlag(0);
					ciservice.insertClientInstrument(b.getClient().getClientId(), b.getInstrument().getInstrumentId(), quan, 'B');
				}
				else {
					ciservice.insertClientInstrument(b.getClient().getClientId(), b.getInstrument().getInstrumentId(), quan, 'B');
				}
				ciservice.insertClientInstrument(s.getClient().getClientId(), iid, quan, 'S');
				thservice.insertTradeHistory(l.get(0),sid,  iid, p, quan);
				quan=0;
			}
			else {//buyer>seller
				Client bClient=b.getClient();
				bClient.setBalance(bClient.getBalance()-(b.getRemainingQty()*p));
				Client sClient= s.getClient();
				sClient.setBalance(sClient.getBalance()+(b.getRemainingQty()*p));
				s.setRemainingQty(s.getRemainingQty()-b.getRemainingQty());
				int bquant=b.getRemainingQty();
				quan=quan-bquant;
				cservice.updateClient(bClient);
				cservice.updateClient(sClient);
				b.setRemainingQty(0);
				b.setFlag(0);
				ciservice.insertClientInstrument(b.getClient().getClientId(), iid, bquant, 'B');
				ciservice.insertClientInstrument(s.getClient().getClientId(), iid, bquant, 'S');
				thservice.insertTradeHistory( l.get(0),sid, iid, p, bquant);
				
			}
			brepo.save(b);
			srepo.save(s);
			l.remove(0);
		}
		return sid;
	}
	
	public List<Sell> getSell(){
		List<Sell> s=new ArrayList<>();
		 this.srepo.findAll().forEach(ele->s.add(ele));
		 return s;
	}
	public Sell findById(int sid) {
		try {
			Optional<Sell> c=this.srepo.findById(sid);
			return c.orElseThrow(()->{
				return new EntityNotFoundException("Sell with "+sid + " does not exist");
			});
			}
		catch(IllegalArgumentException iae) {
			return null;
		}
	}
	
	
}
