package com.dbs.ordermatching.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.model.TradeHistory;
import com.dbs.ordermatching.service.TradeHistoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tradehistory")
public class TradeHistoryRestController {
	@Autowired
	private TradeHistoryService thservice;
	
	@GetMapping("/custodian/{csid}")
	public ResponseEntity<Object> getTradeHistoryByCustodian(@PathVariable String csid){
		List<TradeHistory> l=thservice.getTradeHistoryByCustodian(csid);
		if(l.size()>0)
			return ResponseEntity.status(HttpStatus.OK)
					.body(l);
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("No transactions under the given custodianid");
	}
}
