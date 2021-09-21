package com.dbs.aop.SpringAOPDemo;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@Configuration
@Aspect
@EnableAspectJAutoProxy
public class App 
{
    public static void main( String[] args )
    {
        
      AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(App.class);
      EmpService s1= context.getBean(EmpService.class);
      s1.setCname("Shalni");
      CustomerServiceImpl s2= context.getBean(CustomerServiceImpl.class);
      System.out.println(s2.getClass().getName());
    }
}
