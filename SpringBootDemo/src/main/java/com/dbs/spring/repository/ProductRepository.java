package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
