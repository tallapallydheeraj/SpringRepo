package com.dbs.hibernate.HIbernateDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Comparable<Product> {
	@Id
	private int pid;
	@Column(name="prodname")
	private String pname;
	private double price;
	
	//private Invoices invoice;
	
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

	//@Value("100")
	public void setPid(int pid) {
		System.out.println("Product set id called "+pid);
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	//@Value("Speaker")
	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	//@Value("2000")
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return this.getPname().compareTo(o.getPname());
	}
	
	
}
