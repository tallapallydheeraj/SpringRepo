package com.dbs.ordermatching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dbs.ordermatching.service.InstrumentService;
import com.dbs.ordermatching.service.TradeHistoryService;

@SpringBootApplication
public class OrdermatchingApplication {

	
	public static void main(String[] args)throws Exception {
		ApplicationContext context= SpringApplication.run(OrdermatchingApplication.class, args);
		//SellService ser= context.getBean(SellService.class);
		//BuyService ser= context.getBean(BuyService.class);
		//System.out.println(ser.findClientsByCustodianId("CS001"));
		//ser.insertSSell("DBS014", "I003",500.00, 25);
		//ser.insertSBuy("DBS008", "I003",500.00, 25);
		//System.out.println(ser.insertBuy());
		//TradeHistoryService ser= context.getBean(TradeHistoryService.class);
		InstrumentService ser= context.getBean(InstrumentService.class);
		System.out.println( ser.getAllInstrumentsByCustodian("CS001"));
	}

}
