package com.dbs.ordermatching;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dbs.ordermatching.model.Custodian;
import com.dbs.ordermatching.repo.CustodianRepository;
import com.dbs.ordermatching.service.CustodianService;
import com.dbs.ordermatching.service.InstrumentService;
import com.dbs.ordermatching.service.TradeHistoryService;
import com.dbs.ordermatching.util.JwtUtil;

@SpringBootApplication
public class OrdermatchingApplication {

	@Autowired
	private CustodianService service;
	@Autowired
	private CustodianRepository repo;
	public static void main(String[] args)throws Exception {
		ApplicationContext context= SpringApplication.run(OrdermatchingApplication.class, args);
		//SellService ser= context.getBean(SellService.class);
		//BuyService ser= context.getBean(BuyService.class);
		//System.out.println(ser.findClientsByCustodianId("CS001"));
		//ser.insertSSell("DBS014", "I003",500.00, 25);
		//ser.insertSBuy("DBS008", "I003",500.00, 25);
		//System.out.println(ser.insertBuy());
		//TradeHistoryService ser= context.getBean(TradeHistoryService.class);
		//InstrumentService ser= context.getBean(InstrumentService.class);
		//System.out.println( ser.getAllInstrumentsByCustodian("CS001"));
	}
	@PostConstruct
	//@Bean
	public void initialize() {
		System.out.println("initialize");
		Custodian user=new Custodian("CS003","EuroClear Belgium",new BCryptPasswordEncoder().encode("CS003"));

		repo.save(user);
		System.out.println(repo.count());
	}
	/*@Bean
	public JwtUtil utility() {
		return new JwtUtil();
	}*/
	

}
