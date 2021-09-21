package com.dbs.project.LoanProposalProject.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dbs.project.LoanProposalProject.App;
import com.dbs.project.LoanProposalProject.model.Customer;

public class CustomerService {

	
	
	public CustomerService() {
		System.out.println("Customer service");
	}
	
	public Customer findCustomerByEmail(String email)
	{
		SessionFactory factory=App.getSessionFactoryObject();
		Session session = factory.openSession();
		Customer customer = session.get(Customer.class, email);
		session.close();
		return customer;
		
	}
	
	public boolean addCustomer(Customer customer) {
		SessionFactory factory=App.getSessionFactoryObject();
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(customer);
		tx.commit();
		session.close();
		return true;
	}
	
}
