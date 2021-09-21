package com.dbs.web.beans.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
