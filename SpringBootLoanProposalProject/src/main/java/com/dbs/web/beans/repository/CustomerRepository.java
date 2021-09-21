package com.dbs.web.beans.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
