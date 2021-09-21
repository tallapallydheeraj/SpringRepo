package com.dbs.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product{

	@Id
	private int pid;
	@Column(name="prodname")
	private String pname;
	private double price;
	
	public Product() {
		System.out.println("Product default constructor");
	}

	public Product(
	int pid, String pname, double price) {
		super();
		System.out.println("Product parameterized constructor "+pid);
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		System.out.println("Product set id called "+pid);
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
	
}
