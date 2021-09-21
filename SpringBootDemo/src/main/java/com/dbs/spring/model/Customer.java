package com.dbs.spring.model;

import java.io.Serializable;

public class Customer implements Serializable{
	
	private String customerName;
	
	private String customerAddress;
	
	private String customerEmailId;
	private String customerIdentity;
	
	private double annualIncome;
	
	private String password;
	
	private boolean incomeTaxReturnAttached;
	
	public Customer() {
		System.out.println("customer");
	}
	
	public Customer( String customerName, String customerAddress, String customerEmailId,
			String customerIdentity, double annualIncome, boolean incomeTaxReturnAttached) {
		super();
		
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmailId = customerEmailId;
		this.customerIdentity = customerIdentity;
		this.annualIncome = annualIncome;
		this.incomeTaxReturnAttached = incomeTaxReturnAttached;
	}
	
	
	public Customer(String customerName, String customerAddress, String customerEmailId, String customerIdentity,
			double annualIncome, String password, boolean incomeTaxReturnAttached) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmailId = customerEmailId;
		this.customerIdentity = customerIdentity;
		this.annualIncome = annualIncome;
		this.password = password;
		this.incomeTaxReturnAttached = incomeTaxReturnAttached;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getCustomerIdentity() {
		return customerIdentity;
	}
	public void setCustomerIdentity(String customerIdentity) {
		this.customerIdentity = customerIdentity;
	}
	
	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public boolean isIncomeTaxReturnAttached() {
		return incomeTaxReturnAttached;
	}
	public void setIncomeTaxReturnAttached(boolean incomeTaxReturnAttached) {
		this.incomeTaxReturnAttached = incomeTaxReturnAttached;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerEmailId="
				+ customerEmailId + ", customerIdentity=" + customerIdentity + ", annualIncome=" + annualIncome
				+ ", password=" + password + ", incomeTaxReturnAttached=" + incomeTaxReturnAttached + "]";
	}

}
