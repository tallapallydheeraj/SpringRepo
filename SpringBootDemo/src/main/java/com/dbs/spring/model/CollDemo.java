package com.dbs.spring.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollDemo {
	
	private List<String> fruits;
	private Set<String> certificates;
	private Map<String, String> map;
	private List<Product> products;
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<String> getFruits() {
		return fruits;
	}
	public void setFruits(List<String> fruits) {
		this.fruits = fruits;
	}
	public Set<String> getCertificates() {
		return certificates;
	}
	public void setCertificates(Set<String> certificates) {
		this.certificates = certificates;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	

}
