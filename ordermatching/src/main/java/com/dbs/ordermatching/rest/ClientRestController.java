package com.dbs.ordermatching.rest;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.custom.CustomClient;
import com.dbs.ordermatching.model.Client;
import com.dbs.ordermatching.service.ClientService;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
public class ClientRestController {
	@Autowired
	private ClientService cservice;
	@GetMapping("/{clientId}")
	public ResponseEntity<Object> getClientDetailsByClientId(@PathVariable String clientId) {
		Client client = null;
		try {
			
			System.out.println("Received here"+clientId);
			
			 client = this.cservice.findClientById(clientId);
			 
			 System.out.println("client"+client);
			 
			 if(client==null) {
				 throw new EntityNotFoundException();
				 }
			
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
		}
		CustomClient cc=new CustomClient();
		cc.setClientId(client.getClientId());
		cc.setClientName(client.getClientName());
		cc.setCustodianId(client.getCustodian().getCustodianId());
		cc.setTransactionLimit(client.getTransactionLimit());
		cc.setBalance(client.getBalance());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				cc);
	}
	
	@GetMapping("/buyreport")
	public ResponseEntity<Object> generateBuyReport(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(cservice.generateBuyReport());
	}
	@GetMapping("/sellreport")
	public ResponseEntity<Object> generateSellReport(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(cservice.generateSellReport());
	}
	/*@GetMapping
	public List<String> getClientIds() {
		return this.cservice.getAllClientIds();
	}*/
}
