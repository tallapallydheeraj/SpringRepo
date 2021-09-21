package com.dbs.ordermatching.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.model.Instrument;
import com.dbs.ordermatching.service.InstrumentService;

@RestController
@RequestMapping("/instruments")
@CrossOrigin(origins = "*")
public class InstrumentRestController {
	@Autowired
	private InstrumentService iservice;
	@GetMapping
	public List<Instrument> getInstruments() {
		return this.iservice.getAllInstruments();
	}
	@GetMapping("/{instrumentId}")
	public ResponseEntity<Object> getInstrumentDetailsByInstrumentId(@PathVariable String instrumentId) {
		Instrument instrument = null;
		try {
			 instrument = this.iservice.findInstrumentById(instrumentId);
			 
			 if(instrument==null) {
				 throw new EntityNotFoundException();
				 }
			
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				instrument);
	}
	@GetMapping("/custodian/{csid}")
	public ResponseEntity<Object> getByCustodian(@PathVariable String csid){
		return ResponseEntity.status(HttpStatus.OK)
				.body(iservice.getAllInstrumentsByCustodian(csid));
	}
}
