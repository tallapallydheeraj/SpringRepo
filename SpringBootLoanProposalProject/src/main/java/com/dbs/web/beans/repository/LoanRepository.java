package com.dbs.web.beans.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Loan;

public interface LoanRepository extends CrudRepository<Loan, String> {

}
