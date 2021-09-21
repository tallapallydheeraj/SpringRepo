package com.dbs.ordermatching.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.model.Sell;
import com.dbs.ordermatching.service.SellService;
@RestController
@RequestMapping("/sell")
@CrossOrigin(origins = "*")
public class SellRestController {
	
	@Autowired
	private SellService sservice;
	@PostMapping
	public ResponseEntity<Object> insertCSell(@RequestBody Sell sell) throws Exception{
		String cid=sell.getClient().getClientId();
		String iid=sell.getInstrument().getInstrumentId();
		double p=sell.getPrice();
		int q=sell.getQuantity();
		int sid=this.sservice.insertSSell(cid, iid, p, q);
		if (sid!=-1)
			return ResponseEntity.status(HttpStatus.OK)
					.body(sservice.findById(sid));
		else 
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body("Your Transaction Limit exceeded");
	}
}
