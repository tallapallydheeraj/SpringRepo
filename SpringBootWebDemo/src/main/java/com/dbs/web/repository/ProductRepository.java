package com.dbs.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Product;



public interface ProductRepository extends CrudRepository<Product, Integer>{

	// select * from product where price > 20
	public List<Product> findAllByPriceGreaterThan(double price);
	
	
}
