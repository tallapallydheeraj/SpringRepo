package com.dbs.web;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dbs.web.beans.Account;
import com.dbs.web.beans.Customer;
import com.dbs.web.beans.Invoices;
import com.dbs.web.beans.Product;
import com.dbs.web.repository.AccountREpository;
import com.dbs.web.repository.CustomerRepository;
import com.dbs.web.repository.InvoiceRepository;
import com.dbs.web.repository.ProductRepository;

@SpringBootApplication

public class SpringWebDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebDemoApplication.class, args);
	}

	@Autowired
	private ProductRepository repo;

	@Autowired
	private CustomerRepository custrepo;

	@Autowired
	private InvoiceRepository invrepo;

	@Autowired
	private AccountREpository repo1;

	@PostConstruct
	//@Bean
	public void initialize() {
		System.out.println("initialize");
		List<Account> accs = Stream.of(
				new Account(1, "abc", encoder().encode("abc"), "ROLE_USER", true),
				new Account(2, "abc1", encoder().encode("abc"), "ROLE_USER", true),
				new Account(3, "abc2", encoder().encode("abc"), "ROLE_USER", true),
				new Account(4, "abc3", encoder().encode("abc"), "ROLE_USER", true),
				new Account(5, "admin", encoder().encode("admin"), "ROLE_ADMIN, ROLE_USER", true)).collect(Collectors.toList());

		repo1.saveAll(accs);
		System.out.println(repo.count());
		for(Account acc:repo1.findAll())
			System.out.println(acc);
	}
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public void insertProductData()
	{
		System.out.println("inserting product");
		List<Product> products = Arrays.asList(
				new Product(2, "Eraser", 12.0),
				new Product(3, "Scale", 15.0),
				new Product(4, "Notebook one-line", 42.0),
				new Product(5, "Register", 92.0));
		repo.saveAll(products);
	}
	@Bean
	public void insertCustomerData()
	{
		System.out.println("inserting customer");
		List<Customer> customers = Arrays.asList(
				new Customer("Shalini", "Mumbai", "shalini@gmail.com", null, 0, false,"shalini"),
				new Customer("Nithya", "Delhi", "nithya@gmail.com", "Passport", 1200000, false,"nithya"),
				new Customer("Manish", "Pune", "manish@gmail.com", "Aadhar", 8989890, true,"manish"),
				new Customer("Rahul", "Mumbai", "rahul@gmail.com", null, 0, false,"rahul"),
				new Customer("Praveen", "Mumbai", "praveen@gmail.com", null, 0, false,"praveen")
				);
		custrepo.saveAll(customers);
	}
	@Bean
	public void insertInvoiceData()
	{
		System.out.println("inserting invoice");
		List<Invoices> invoices = Arrays.asList(
				new Invoices("I004", custrepo.findById("nithya@gmail.com").get(), 
						LocalDate.of(2021, 6, 16), 
						repo.findById(1).get(), 12, 240),
				new Invoices("I002", custrepo.findById("manish@gmail.com").get(), 
						LocalDate.of(2020, 2, 20), 
						repo.findById(2).get(), 2, 24),
				new Invoices("I003", custrepo.findById("nithya@gmail.com").get(), 
						LocalDate.of(2021, 1, 1), 
						repo.findById(3).get(), 5, 75.0)
				);
		invrepo.saveAll(invoices);
	}

}
