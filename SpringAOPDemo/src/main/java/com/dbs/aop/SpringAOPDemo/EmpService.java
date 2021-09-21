package com.dbs.aop.SpringAOPDemo;

import org.springframework.stereotype.Component;

@Component
public class EmpService {

	private String cname;

	public String getCname() {
		return cname;
	}

	public void setCname(
			String cname) {
		System.out.println("set name");
		this.cname = cname;
	}
	public String applyNow()
	{
		System.out.println("Emp Servcie apply now called");
		return "Done";
	}
	public void applyThen() throws Exception
	{
		System.out.println("Emp Servcie apply THEN called");
		throw new Exception("emp service threw an exception");
	}
}
