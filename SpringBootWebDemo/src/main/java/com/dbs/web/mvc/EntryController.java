package com.dbs.web.mvc;

import java.security.Principal;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbs.web.beans.Customer;
import com.dbs.web.beans.User;
import com.dbs.web.repository.CustomerRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//https://marketplace.eclipse.org/search/site/web%2520eclipse
// web mvc => req and response
@Controller
@SecurityRequirement(name = "api")
public class EntryController {

	@Autowired
	private CustomerRepository repo;
	
	Logger logger = Logger.getLogger(EntryController.class.getName());
	

	
	
	//http://localhost:8080/
	@GetMapping
	public String homePage()
	{
		System.out.println("index home page");
		// view name
		return "index";
	}
	
	@GetMapping("/signin")
	public String login(@RequestParam(required = false) String error, 
			Map<String, String> maperror)
	{
		System.out.println("login page");
		maperror.put("error", error);
		// view name
		return "login";
	}
	
	public static final String ID_TYPE[]= {"Passport", "Driving license","Aadhar Card"};
	@GetMapping("/register")
	public String registration(Map<String, String[]> map)
	{
		map.put("types", ID_TYPE);
		return "register";
	}
	
	@PostMapping("/signin")
	public String validate(User user, 
			Map<String, Customer> map,
			Map<String, String> maperror,
			HttpSession session)
	{
		System.out.println("post signin");
		logger.info("Map "+map.keySet());
		//System.out.println("validate "+user);
		Optional<Customer> cust = this.repo.findById(user.getEmail());
		if(cust.isPresent())
		{
			Customer customer = cust.get();
			session.setAttribute("cust", customer);
			//map.put("cust", customer);
			return "redirect:/dashboard";
		}
		maperror.put("error","Invalid Credentials");
		// view name
		return "redirect:/login?error=Invalid Credentials";
	}
}
