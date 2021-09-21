package com.dbs.ordermatching.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.ordermatching.model.ClientInstrument;
import com.dbs.ordermatching.model.TradeHistory;
import com.dbs.ordermatching.repo.BuyRepository;
import com.dbs.ordermatching.repo.SellRepository;
import com.dbs.ordermatching.repo.TradeHistoryRepository;

@Service
public class TradeHistoryService {
	@Autowired
	private TradeHistoryRepository threpo;
	@Autowired
	private InstrumentService iservice;
	@Autowired
	private BuyRepository brepo;
	@Autowired
	private SellRepository srepo;
	public boolean insertTradeHistory(int bid,int sid,String iid,
			double price,
			int quantity) throws Exception {
		TradeHistory th = new TradeHistory();
		th.setBuyer(brepo.findById(bid).get().getClient());
		th.setSeller(srepo.findById(sid).get().getClient());
		th.setInstrument(iservice.findInstrumentById(iid));
		th.setPrice(price);
		th.setQuantity(quantity);
		th.setTradeDate(LocalDateTime.now());
		threpo.save(th);
		return true;
	}
	public List<TradeHistory> getTradeHistoryByCustodian(String csid){
		return threpo.getTradeHistoryByCustodian(csid);
	}
}
