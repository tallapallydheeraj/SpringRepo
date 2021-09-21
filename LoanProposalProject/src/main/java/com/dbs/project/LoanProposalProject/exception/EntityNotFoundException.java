package com.dbs.project.LoanProposalProject.exception;

public class EntityNotFoundException  extends Exception{
	
	String message;
	public EntityNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	

	public EntityNotFoundException(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
