package com.dbs.web.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Account;

public interface AccountREpository extends CrudRepository<Account,Long>{

	public Optional<Account> findByUsername(String username);
}
