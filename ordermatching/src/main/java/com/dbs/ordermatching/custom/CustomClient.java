package com.dbs.ordermatching.custom;

public class CustomClient {
	private String clientId;
	private String clientName;
	private String custodianId;
	private double transactionLimit;
	private double balance;
	public CustomClient() {
		// TODO Auto-generated constructor stub
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
	public String getCustodianId() {
		return custodianId;
	}
	public void setCustodianId(String custodianId) {
		this.custodianId = custodianId;
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
	public CustomClient(String clientId, String clientName, String custodianId, double transactionLimit,
			double balance) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.custodianId = custodianId;
		this.transactionLimit = transactionLimit;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "CustomClient [clientId=" + clientId + ", clientName=" + clientName + ", custodianId=" + custodianId
				+ ", transactionLimit=" + transactionLimit + ", balance=" + balance + "]";
	}
	
}
