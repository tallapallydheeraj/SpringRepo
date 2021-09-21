package com.dbs.ordermatching.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.service.CustodianService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/custodian")
public class CustodianRestController {
	
	@Autowired
	private CustodianService csservice;
	
	@GetMapping("/buyreport")
	public ResponseEntity<Object> generateBuyReport(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(csservice.generateBuyReport());
	}
	@GetMapping("/sellreport")
	public ResponseEntity<Object> generateSellReport(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(csservice.generateSellReport());
	}
}
