package com.dbs.hibernate.HIbernateDemo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	private int eid;
	private String ename;
	private String city;
	@ElementCollection
	private Set<String> certificates;
	@ElementCollection
	@JoinTable(name="phone_numbers",
			joinColumns = @JoinColumn(name="empid"))
	@Column(name="numbers")
	private List<String> phonenumbers;
	@OneToMany
	private List<Email> emailids;

	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<String> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<String> certificates) {
		this.certificates = certificates;
	}

	public List<String> getPhonenumbers() {
		return phonenumbers;
	}

	public void setPhonenumbers(List<String> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}

	public List<Email> getEmailids() {
		return emailids;
	}

	public void setEmailids(List<Email> emailids) {
		this.emailids = emailids;
	}
	
	

}
