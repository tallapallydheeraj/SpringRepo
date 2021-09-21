package com.dbs.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Invoices;



public interface InvoiceRepository extends CrudRepository<Invoices, String>{

	public List<Invoices> findAllByCustnameCustomerEmailId(String email);
	
	@Query(value = "SELECT max(invno) FROM Invoices")
	public String getMaxInvoiceId();
}
