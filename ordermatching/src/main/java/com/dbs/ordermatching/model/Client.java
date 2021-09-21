package com.dbs.ordermatching.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="clients")
public class Client {
	@Id
	@Column(name="clientid")
	private String clientId;
	@Column(name="clientname")
	private String clientName;
	@OneToOne
	@JoinColumn(name="custodianid")
	private Custodian custodian;
	@Column(name="transactionlimit")
	private double transactionLimit;
	private double balance;
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public Client(String clientId, String clientName, Custodian custodian, double transactionLimit, double balance) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.custodian = custodian;
		this.transactionLimit = transactionLimit;
		this.balance = balance;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Custodian getCustodian() {
		return custodian;
	}
	public void setCustodian(Custodian custodian) {
		this.custodian = custodian;
	}
	public double getTransactionLimit() {
		return transactionLimit;
	}
	public void setTransactionLimit(double transactionLimit) {
		this.transactionLimit = transactionLimit;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", custodian=" + custodian
				+ ", transactionLimit=" + transactionLimit + ", balance=" + balance + "]";
	}
}
