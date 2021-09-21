package com.dbs.project.LoanProposalProject.service;

import java.util.List;
import java.util.Random;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dbs.project.LoanProposalProject.App;
import com.dbs.project.LoanProposalProject.constants.LoanConstants;
import com.dbs.project.LoanProposalProject.exception.EntityNotFoundException;
import com.dbs.project.LoanProposalProject.model.Employee;
import com.dbs.project.LoanProposalProject.model.Loan;



public class LoanService {



	public Loan findLoanById(String loanId) throws EntityNotFoundException
	{
		SessionFactory factory = App.getSessionFactoryObject();
		Session session = factory.openSession();
		Loan loan = session.get(Loan.class, loanId);
		session.close();
		return loan;
	}


	public boolean uploadCollateral(String loanId, List<String> collateralIds) 
	{
		Loan loan=null;
		try {
			loan=this.findLoanById(loanId);
			
		}
		catch(EntityNotFoundException e) {
			System.out.println("");
		}
		if(loan==null) return false;
		else {
			return true;
		}
	}
	public Loan applyForLoan(String loanType, double loanAmount,
			double period, String email)
	{
		SessionFactory factory=App.getSessionFactoryObject();
		Session session = factory.openSession();
		Loan loan = new Loan();
		loan.setLoanId("abkb"+email);
		loan.setLoanType(loanType);
		loan.setLoanAmount(loanAmount);
		loan.setInterestRate(new LoanConstants().calculateRate(period));
		loan.setPeriod(period);
		loan.setCustomer(null);
		List<Employee> l= session.createQuery("FROM Employee").list();
		Random random=new Random();
		loan.setEmployee(l.get(random.nextInt(l.size())));
		
		System.out.println("applying for loan");

		return null;
	}

}
