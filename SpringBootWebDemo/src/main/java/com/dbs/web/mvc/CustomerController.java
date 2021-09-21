package com.dbs.web.mvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dbs.web.beans.Customer;
import com.dbs.web.beans.Invoices;
import com.dbs.web.service.InvoiceService;

@Controller
public class CustomerController {

	@Autowired
	private InvoiceService invservice;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session)
	{
		if(session.getAttribute("cust") == null)
		{
			return "redirect:/login";
		}
		System.out.println("dashboard");
		return "customer";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("cust") ;
		session.invalidate();
		return "redirect:/login";
	}
	@GetMapping("/invoice")
	public String invoices(HttpSession session,
			Map<String, List<Invoices>> map)
	{
		Customer customer = (Customer) session.getAttribute("cust");
		List<Invoices> list = this.invservice.getAllInvoicesByCustomerId(customer.getCustomerEmailId());
		map.put("invoices",list);
		return "invoices";
	}
	
}
