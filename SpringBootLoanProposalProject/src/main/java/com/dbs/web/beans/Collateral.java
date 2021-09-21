package com.dbs.web.beans;

import java.io.Serializable;

public class Collateral  implements Serializable{

	private String collateralId;
	private String collateralType;
	
	public Collateral() {
		System.out.println("entity created");
	}

	public Collateral(String collateralId, String collateralType) {
		super();
		this.collateralId = collateralId;
		this.collateralType = collateralType;
	}

	public String getCollateralId() {
		return collateralId;
	}

	public void setCollateralId(String collateralId) {
		this.collateralId = collateralId;
	}

	public String getCollateralType() {
		return collateralType;
	}

	public void setCollateralType(String collateralType) {
		this.collateralType = collateralType;
	}

	@Override
	public String toString() {
		return "Collateral [collateralId=" + collateralId + ", collateralType=" + collateralType + "]";
	}
	
}
