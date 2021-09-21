package com.dbs.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Customer;
import com.dbs.web.beans.Employee;
import com.dbs.web.beans.Loan;
import com.dbs.web.beans.repository.EmployeeRepository;
import com.dbs.web.beans.repository.LoanRepository;
import com.dbs.web.exception.EntityNotFoundException;


@Service
public class EmployeeService {


	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	public void approveLoan(String eid) throws Exception {

		if(searchEmployeeById(eid)) {

			List<Loan> loans = loanRepository.findAllByEmployeeEmployeeId(eid);
			if(loans.size()>0) {
				for(Loan loan:loans) {
					Customer customer = loan.getCustomer();
					System.out.println("get collaterals "+loan.getCollaterals());
					if(loan.getLoanAmount() > (10 * customer.getAnnualIncome())) {
						loan.setRemarks("Loan amount cannot be 10 times of annual income");
						loan.setApproved(false);
						this.loanRepository.save(loan);
						
					}
					else if(loan.getCollaterals() == null || loan.getCollaterals().size() == 0) {
						loan.setRemarks( "No collateral submitted");
						loan.setApproved(false);
						this.loanRepository.save(loan);
						
					}
					else if(!customer.isIncomeTaxReturnAttached()) {
						loan.setRemarks( "Income proof not attached");
						loan.setApproved(false);
						this.loanRepository.save(loan);
						
					}
					else if(customer.getCustomerIdentity() == null) {
						loan.setRemarks( "Identity document not submitted");
						loan.setApproved(false);
						this.loanRepository.save(loan);
						
					}
					else
					{
						loan.setRemarks( "Approved");
						loan.setApproved(true);
						
						this.loanRepository.save(loan);
						
					}
				}
			}
			else {
				throw new Exception("No loan proposals against this employee id");
			}
		}
		else
			throw new EntityNotFoundException("Employee does not exist");
	}
	public boolean searchEmployeeById(String empid) throws Exception
	{
		try {
			if(this.employeeRepository.findById(empid).isPresent())
				return true;
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(e);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return false;
	}

	public boolean addEmployee(Employee employee) throws Exception {

		try {
			if(this.searchEmployeeById(employee.getEmployeeId()))
			{
				return false;
			}
			this.employeeRepository.save(employee);
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(e);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return true;
	}

}
