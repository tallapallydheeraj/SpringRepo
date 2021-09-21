package com.dbs.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.web.beans.Invoices;
import com.dbs.web.beans.ResponsePage;
import com.dbs.web.service.InvoiceService;

@RestController
@RequestMapping("/invoices")
@CrossOrigin
public class InvoiceRestController {

	@Autowired
	private InvoiceService service;
	
	
	@GetMapping(path = "/{email}", produces = "application/json")
	public List<Invoices> getInvoices(@PathVariable String email)
	{
		System.out.println(this.service.count());
		return  this.service.getAllInvoicesByCustomerId(email);
	}
	@PostMapping
	public ResponseEntity<ResponsePage> insertInvoice(@RequestBody Invoices invoice)
	{
		System.out.println(this.service.count());
//		if( service.insertInvoice(invoice))
//			return  ResponseEntity
//					.status(HttpStatus.ACCEPTED)
//					.body("Invoice inserted with id ");
//		return  ResponseEntity
//				.status(HttpStatus.NOT_FOUND)
//				.body("Product not inserted with id ");
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ResponsePage());
	}
	
}
