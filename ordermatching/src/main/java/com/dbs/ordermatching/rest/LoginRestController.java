package com.dbs.ordermatching.rest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dbs.ordermatching.model.AuthenticationRequest;
import com.dbs.ordermatching.model.AuthenticationResponse;
import com.dbs.ordermatching.model.Client;
import com.dbs.ordermatching.service.AccountUserDetailsService;
import com.dbs.ordermatching.service.ClientService;
import com.dbs.ordermatching.service.CustodianService;
import com.dbs.ordermatching.util.JwtUtil;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@RestController
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "api")
public class LoginRestController {
	
	@Autowired
	private CustodianService csservice;
	@Autowired
	private ClientService cservice;
	
	@Autowired
	private AccountUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
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
	
	@GetMapping("/clientDetails/{custodianId}")
	public ResponseEntity<Object> getClientDetailsByCustodianId(@PathVariable String custodianId) {
		List<Client> clientsList = new ArrayList<>();
		try {
			System.out.println("received custodian id"+custodianId);
			System.out.println("Initial clientList size"+clientsList);
			 clientsList = this.cservice.findClientsByCustodianId(custodianId);
			 System.out.println("Updated clientList size"+clientsList);
			 
			 if(clientsList.size()==0) {
				 System.out.println("Entered in if");
				 throw new EntityNotFoundException();
				 }
		}
		catch(Exception e )
		{
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				clientsList);
	}
//	@GetMapping("/clientDetails")
//	public ResponseEntity<Object> getClientDetailsByCustodianId(Principal p) {
//		List<Client> clientsList = new ArrayList<>();
//		//try {
//			System.out.println("received custodian id"+p.getName());
//			System.out.println("Initial clientList size"+clientsList);
//			 //clientsList = this.cservice.findClientsByCustodianId(custodianId);
////			 System.out.println("Updated clientList size"+clientsList);
////			 
////			 if(clientsList.size()==0) {
////				 System.out.println("Entered in if");
////				 throw new EntityNotFoundException();
////				 }
////		}
////		catch(Exception e )
////		{
////			System.out.println(e);
////			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
////		}
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
//				clientsList);
//	}
	
	
}
