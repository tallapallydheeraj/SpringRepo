package com.dbs.project.LoanProposalProject.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dbs.project.LoanProposalProject.App;
import com.dbs.project.LoanProposalProject.exception.EntityNotFoundException;
import com.dbs.project.LoanProposalProject.model.Employee;

public class EmployeeService {




	public void approveLoan(String eid) throws Exception {


	}
	public boolean searchEmployeeById(String empid)
	{
		SessionFactory factory=App.getSessionFactoryObject();
		Session session=factory.openSession();
		Employee employee = session.get(Employee.class, empid);
		session.close();
		if(employee==null) {
			return false;
		}
		else {
			return true;
		}

	}

	public boolean addEmployee(Employee employee) {
		try {
		SessionFactory factory=App.getSessionFactoryObject();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
		return true;
		}
		catch(Exception e) {
			System.out.println("there's an exception in adding the employee");
			return false;
		}
	}

}
