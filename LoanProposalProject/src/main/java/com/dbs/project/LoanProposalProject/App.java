package com.dbs.project.LoanProposalProject;

import org.hibernate.SessionFactory;



/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory factory = HibConfig.getSessionFactory();
    public static void main( String[] args )
    {
       System.out.println("Connected to ABKB");
    }
    public static SessionFactory getSessionFactoryObject() {
    	return factory;
    }
}
