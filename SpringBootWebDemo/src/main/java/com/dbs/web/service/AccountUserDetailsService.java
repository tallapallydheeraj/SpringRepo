package com.dbs.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Account;
import com.dbs.web.repository.AccountREpository;

@Service
public class AccountUserDetailsService implements UserDetailsService{

	@Autowired
	private AccountREpository repo;
	
	@Autowired
	private PasswordEncoder encode;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("Username "+username);
		Optional<Account> optional = this.repo.findByUsername(username);
		return optional.map(account ->{
			User user = new User(account.getUsername(), account.getPassword(),
					Arrays.stream(account.getRole().split(","))
					.map(role -> new SimpleGrantedAuthority(role))
					.collect(Collectors.toList()));
			return user;
			
		}).orElseThrow(()-> new UsernameNotFoundException("Invalid Credentials"));
		
//		use below code if you are not providing roles	
		
//		return optional.map(account ->{
//			User user = new User(account.getUsername(), account.getPassword(),
//					new ArrayList<>());
//			return user;
//			
//		}).orElseThrow(()-> new UsernameNotFoundException("Invalid Credentials"));
	}
}
