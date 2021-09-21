package com.dbs.hibernate.HIbernateDemo.model;

import java.time.LocalDate;

import javax.persistence.*;


@Entity
public class Invoices {

	@Id
	private String invno;
	@Column(name="cname",nullable=false)
	private String custname;
	private LocalDate date;
	@OneToOne
	private Product product;
	private int qty;
	
	private double invoiceamount;
	
	public Invoices() {
		System.out.println("Invoices def constructor");
	}

	
	public Invoices(String invno, String custname, LocalDate date, Product product, int qty, double invoiceamount) {
		super();
		this.invno = invno;
		this.custname = custname;
		this.date = date;
		this.product = product;
		this.qty = qty;
		this.invoiceamount = invoiceamount;
	}

	public Invoices(String invno, String custname, Product product, int qty, double invoiceamount) {
		super();
		this.invno = invno;
		this.custname = custname;
		this.product = product;
		this.qty = qty;
		this.invoiceamount = invoiceamount;
	}
	public String getInvno() {
		return invno;
	}

	
	public void setInvno(String invno) {
		System.out.println("settter for invno");
		this.invno = invno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Product getProduct() {
		return product;
	}

	
	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getInvoiceamount() {
		return invoiceamount;
	}

	public void setInvoiceamount(double invoiceamount) {
		this.invoiceamount = invoiceamount;
	}

	@Override
	public String toString() {
		return "Invoice [invno=" + invno + ", custname=" + custname + ", date=" + date + ", product=" + product
				+ ", qty=" + qty + ", invoiceamount=" + invoiceamount + "]";
	}
	
}
