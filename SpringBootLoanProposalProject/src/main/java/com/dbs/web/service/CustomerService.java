package com.dbs.web.service;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Customer;
import com.dbs.web.beans.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;


	public CustomerService() {
		System.out.println("Customer service");
	}

	public Customer findCustomerByEmail(String email) throws Exception
	{
		Customer customer = null;
		try {

			Optional<Customer> opt = this.customerRepository.findById(email);
			if(opt.isPresent())
				customer = opt.get();
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("Email cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return customer;

	}

	public boolean addCustomer(Customer customer) throws Exception {

		try {
			if(this.customerRepository.findById(customer.getCustomerEmailId()).isPresent())
			{
				return false;
			}
			this.customerRepository.save(customer);
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(e);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return true;
	}
	public boolean updateCustomer(Customer customer) throws Exception {

		try {
			if(this.customerRepository.findById(customer.getCustomerEmailId()).isPresent())
			{
				this.customerRepository.save(customer);
				return true;
			}	
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(e);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return false;
	}

}
