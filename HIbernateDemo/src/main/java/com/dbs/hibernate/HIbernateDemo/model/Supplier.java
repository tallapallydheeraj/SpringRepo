package com.dbs.hibernate.HIbernateDemo.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Supplier {
	@Id
	private int sid;
	
	private String suppname;
	private String city;
	private String company;
	//@Embedded
	@OneToOne
	private Email email;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSuppname() {
		return suppname;
	}
	public void setSuppname(String suppname) {
		this.suppname = suppname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Supplier [sid=" + sid + ", suppname=" + suppname + ", city=" + city + ", company=" + company
				+ ", email=" + email + "]";
	}
	
	
}
