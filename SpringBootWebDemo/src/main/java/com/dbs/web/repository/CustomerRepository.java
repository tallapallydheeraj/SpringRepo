package com.dbs.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Customer;




public interface CustomerRepository extends CrudRepository<Customer, String>{

}
