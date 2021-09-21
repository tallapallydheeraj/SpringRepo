package com.dbs.spring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDatabase {
	@Autowired
	private JdbcTemplate template;
	 public ProductDatabase() {
	        // TODO Auto-generated constructor stub
	        
	        System.out.println("Product Database constructor");
	    }

	public JdbcTemplate getTemplate() {
		// TODO Auto-generated method stub
		return template;
	}
}
