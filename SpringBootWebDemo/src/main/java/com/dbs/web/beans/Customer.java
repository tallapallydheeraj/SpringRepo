package com.dbs.web.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// model or bean or entity or pojo

@Entity
public class Customer {

	@NotNull
	private String customerName;
	@Column(name="address")
	private String customerAddress;
	@Id
	@Column(name="email")
	//customer_email_id
	@NotNull
	private String customerEmailId;
	private String customerIdentity;
	@Column(name="annualIncome")
	@NotNull
	private double annualIncome;
	private boolean incomeTaxReturnAttached;
	@NotNull
	@Size(min=8)
	private String password;
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, String customerAddress, String customerEmailId, String customerIdentity,
			double annualIncome, boolean incomeTaxReturnAttached, String password) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmailId = customerEmailId;
		this.customerIdentity = customerIdentity;
		this.annualIncome = annualIncome;
		this.incomeTaxReturnAttached = incomeTaxReturnAttached;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerEmailId="
				+ customerEmailId + ", customerIdentity=" + customerIdentity + ", annualIncome=" + annualIncome
				+ ", incomeTaxReturnAttached=" + incomeTaxReturnAttached + ", password=" + password + "]";
	}
	
	
}
