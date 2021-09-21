package com.dbs.ordermatching.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity(name="custodian")
public class Custodian {
	@Id
	@Column(name="custodianid")
	@NotNull
	private String custodianId;
	@Column(name="custodianname")
	@NotNull
	private String custodianName;
	@Column(name="custodianpassword")
	private String custodianPassword;
	public Custodian() {
		// TODO Auto-generated constructor stub
	}
	public Custodian(String custodianId, String custodianName, String custodianPassword) {
		
		this.custodianId = custodianId;
		this.custodianName = custodianName;
		this.custodianPassword = custodianPassword;
	}
	public String getCustodianId() {
		return custodianId;
	}
	public void setCustodianId(String custodianId) {
		this.custodianId = custodianId;
	}
	public String getCustodianName() {
		return custodianName;
	}
	public void setCustodianName(String custodianName) {
		this.custodianName = custodianName;
	}
	public String getCustodianPassword() {
		return custodianPassword;
	}
	public void setCustodianPassword(String custodianPassword) {
		this.custodianPassword = custodianPassword;
	}
	@Override
	public String toString() {
		return "Custodian [custodianId=" + custodianId + ", custodianName=" + custodianName + ", custodianPassword="
				+ custodianPassword + "]";
	}
	
}
