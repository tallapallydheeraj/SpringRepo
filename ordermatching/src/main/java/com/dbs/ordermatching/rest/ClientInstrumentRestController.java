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

import com.dbs.ordermatching.model.ClientInstrument;
import com.dbs.ordermatching.model.Instrument;
import com.dbs.ordermatching.service.ClientInstrumentService;

@RestController
@RequestMapping("/clientinstruments")
@CrossOrigin(origins = "*")
public class ClientInstrumentRestController {

	@Autowired
	private ClientInstrumentService ciservice;
	
	@GetMapping("/custodian/{csid}")
	public ResponseEntity<Object> getClientInstrumentByCustodian(@PathVariable String csid){
		List<ClientInstrument> list=ciservice.getClientInstrumentByCustodian(csid);
		if(list.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("There are no ClientInstruments with the given custodian ID");
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(list);
	}
	
	@GetMapping("/{ciid}")
	public ResponseEntity<Object> getClientInstrumentByClientInstrumentId(@PathVariable String ciid){
		ClientInstrument clientInstrument = null;
		try {
			 clientInstrument = this.ciservice.findClientInstrumentById(ciid);
			 
			 if(clientInstrument==null) {
				 throw new EntityNotFoundException();
				 }
			
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				clientInstrument);
	}
}
