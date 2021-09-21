package com.dbs.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Customer;
import com.dbs.web.beans.Invoices;
import com.dbs.web.repository.CustomerRepository;
import com.dbs.web.repository.InvoiceRepository;


@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Invoices> getAllInvoices()
	{
		List<Invoices> invoices = new ArrayList<Invoices>();
		this.invoiceRepository.findAll().forEach(inv -> invoices.add(inv));
		return invoices;
		
	}
	public List<Invoices> getAllInvoicesByCustomerId(String email)
	{
		List<Invoices> invoices = new ArrayList<Invoices>();
//		this.invoiceRepository.findAll().forEach(inv -> invoices.add(inv));
//		return invoices.stream().filter(inv -> inv.getCustname().getCustomerEmailId().equals(email))
//				.collect(Collectors.toList());
		return this.invoiceRepository.findAllByCustnameCustomerEmailId(email);
		//return invoices;
		
	}
	public String count()
	{
		return this.invoiceRepository.getMaxInvoiceId();
	}
	public List<Customer> getAllCustomers()
	{
		List<Customer> customers = new ArrayList<Customer>();
		this.customerRepository.findAll().forEach(cust -> customers.add(cust));
		return customers;
	}
	
	public boolean insertInvoice(Invoices invoices)
	{
		if(this.invoiceRepository.findById(invoices.getInvno()).isPresent())
			return false;
		try {
			this.invoiceRepository.save(invoices);
		}catch(IllegalArgumentException e )
		{
			return false;
		}
		return true;
	}
	

}
