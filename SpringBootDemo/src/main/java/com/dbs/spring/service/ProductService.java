package com.dbs.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	public long getCount() {
		return this.repo.count();
	}
}
