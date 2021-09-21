package com.dbs.web.mvc;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.dbs.web.beans.AuthenticationRequest;
import com.dbs.web.beans.AuthenticationResponse;
import com.dbs.web.service.AccountUserDetailsService;
import com.dbs.web.util.JwtUtil;

@RestController
@CrossOrigin( origins = "*")
public class JwtController {

	@Autowired
	private AccountUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/user")
	public String princ(Principal p)
	{
		System.out.println("index home page");
		// view name
		return "Current user :"+p.getName();
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(
			@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
		System.out.println("authenticate ......");
		System.out.println(authenticationRequest.getUsername());
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), 
							authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException e)
		{
			throw new Exception();
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
}

