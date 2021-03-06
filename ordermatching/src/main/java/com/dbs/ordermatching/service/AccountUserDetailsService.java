package com.dbs.ordermatching.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dbs.ordermatching.model.Custodian;
import com.dbs.ordermatching.repo.CustodianRepository;


@Service
public class AccountUserDetailsService implements UserDetailsService{

	public AccountUserDetailsService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private CustodianRepository repo;
	
	//@Autowired

	//private PasswordEncoder encode;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("Username "+username);
		
		Optional<Custodian> optional = this.repo.findById(username);
		return optional.map(account ->{
			User user = new User(account.getCustodianId(),account.getCustodianPassword(),
					new ArrayList<>());
			return user;
		}).orElseThrow(()-> new UsernameNotFoundException("Invalid Credentials"));
	}
}
