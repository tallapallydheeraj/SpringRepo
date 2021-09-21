package com.dbs.hibernate.HIbernateDemo;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dbs.hibernate.HIbernateDemo.model.Customer;
import com.dbs.hibernate.HIbernateDemo.model.Invoices;
import com.dbs.hibernate.HIbernateDemo.model.Product;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory factory = HibConfig.getSessionFactory();
    public static void main( String[] args )
    {
        System.out.println("Connected to database");
        Customer c1 = new Customer("Shalini", "Mumbai", "shalini@gmail.com", "Passport", 83789237, false);
		Customer c2 = new Customer("Chandana", "Pune", "chandana@gmail.com", "Aadhar", 9898998, true);
		Customer c3 = new Customer("Gautham", "Hyderabad", "gautham@gmail.com", "License", 19998908, false);
		
		Customer c4 = new Customer("Raghu", "Hyderabad", "Raghu@gmail.com", "License", 19998908, false);
		Customer c5 = new Customer("Rachita", "Pune", "Rachita@gmail.com", "License", 19998908, false);
		//insertCustomer(c1);
//		insertCustomer(c4);
//		insertCustomer(c5);
		
//		c1.setCustomerAddress("Delhi");
//		updateCustomer(c1);
//		deleteCustomer(c3);
//		System.out.println(getCustomerById(c1.getCustomerEmailId()));
//		loadCustomerById(c3.getCustomerEmailId());
//		for(Customer c:getAllCustomersByCity("Pune")) {
//			System.out.println(c);
//		}
		Product p1 = new Product(1, "Pencil", 45);
		Product p2 = new Product(2, "Eraser", 15);
		Product p3 = new Product(3, "Sharpener", 5);
		Product p4 = new Product(4, "Ruler", 25);
//		createProducts(p1);
//		createProducts(p2);
//		createProducts(p3);
//		createProducts(p4);
		Invoices i1 = new Invoices("I001", "Shalini", LocalDate.now(), p1, 10, 10*p1.getPrice());
//		createInvoices(i1);
		
    }
    public static void createInvoices(Invoices inv)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(inv);
		tx.commit();
		session.close();
	}
	public static void createProducts(Product p1)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p1);
		tx.commit();
		session.close();
	}
    
    public static Customer getCustomerById(String emailid) {
    	Session session=factory.openSession();
    	Customer c = session.get(Customer.class, emailid);
    	session.close();
    	return c;
    }
    public static List<Customer> getAllCustomers(){
    	Session session=factory.openSession();
    	List<Customer> list=session.createQuery("from Customer").list();
    	session.close();
    	return list;
    }
    public static List<Customer> getAllCustomersByCity(String city){
    	Session session=factory.openSession();
    	Query q=session.createQuery("from Customer where customerAddress=:addr");
    	q.setParameter("addr", city);
    	List list=q.list();
    	session.close();
    	return list;
    }
    public static void loadCustomerById(String emailid) {
    	Session session=factory.openSession();
    	Customer c = session.load(Customer.class, emailid);
    	System.out.println(c.getCustomerEmailId());
    	session.close();
    }
    public static String insertCustomer(Customer customer) {
    	try {
    	Session session=factory.openSession();
    	Transaction tx= session.beginTransaction();
    	String email= (String) session.save(customer);
    	tx.commit();
    	session.close();
    	}
    	catch(Exception e) {
    		System.out.println("emailid exists");
    	}
    	return customer.getCustomerEmailId();
    }
    public static void updateCustomer(Customer customer) {
    	Session session=factory.openSession();
    	Transaction tx= session.beginTransaction();
    	session.update(customer);
    	tx.commit();
    	session.close();
    }
    public static void deleteCustomer(Customer customer) {
    	Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(customer);
		tx.commit();
		session.close();
    }
}
