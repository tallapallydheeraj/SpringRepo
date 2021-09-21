package com.dbs.ordermatching.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.model.Buy;
import com.dbs.ordermatching.service.BuyService;

@RestController
@RequestMapping("/buy")
@CrossOrigin(origins = "*")
public class BuyRestController {
	
	@Autowired
	private BuyService bservice;
	@PostMapping
	public ResponseEntity<Object> insertCBuy(@RequestBody Buy buy) throws Exception{
		String cid=buy.getClient().getClientId();
		String iid=buy.getInstrument().getInstrumentId();
		double p=buy.getPrice();
		int q=buy.getQuantity();
		int bid=this.bservice.insertSBuy(cid, iid, p, q);
		if (bid!=-1)
			return ResponseEntity.status(HttpStatus.OK)
					.body(bservice.findById(bid));
		else 
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body("Your Transaction Limit exceeded");
	}
}
