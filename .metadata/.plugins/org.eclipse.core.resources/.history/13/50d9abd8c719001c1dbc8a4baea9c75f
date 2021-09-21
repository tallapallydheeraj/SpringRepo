package com.dbs.ordermatching.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.custom.AuthenticationRequest;
import com.dbs.ordermatching.model.Client;
import com.dbs.ordermatching.model.Custodian;
import com.dbs.ordermatching.service.ClientService;
import com.dbs.ordermatching.service.CustodianService;

@RestController
@CrossOrigin(origins = "*")
public class LoginRestController {
	
	@Autowired
	private CustodianService csservice;
	@Autowired
	private ClientService cservice;
 
	@PostMapping("/authenticate")
	public ResponseEntity<Object> getLoginValidation(@RequestBody Custodian custodian) {
		Custodian result = null;
		try {
			
			System.out.println("received custodian"+custodian);
			 result = this.csservice.findCustodianById(custodian.getCustodianId());
			 System.out.println(result);
			 if(result ==null ) {
		
					throw new EntityNotFoundException();
			 }
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				result);
	
	}
	
	
	
	
	
	
	
	@GetMapping("/clientDetails/{custodianId}")
	public ResponseEntity<Object> getClientDetailsByCustodianId(@PathVariable String custodianId) {
		List<Client> clientsList = new ArrayList<>();
		try {
			System.out.println("received custodian id"+custodianId);
			System.out.println("Initial clientList size"+clientsList);
			 clientsList = this.cservice.findClientsByCustodianId(custodianId);
			 System.out.println("Updated clientList size"+clientsList);
			 
			 if(clientsList.size()==0) {
				 System.out.println("Entered in if");
				 throw new EntityNotFoundException();
				 }
		}
		catch(Exception e )
		{
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				clientsList);
	}
	
	
}
