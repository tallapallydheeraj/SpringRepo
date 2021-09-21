package com.dbs.spring;
import java.lang.annotation.Annotation;

 

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dbs.spring.database.ProductDatabase;
import com.dbs.spring.service.ProductService;

 

/**
 * 
 * @author Administrator
 *
 */
@SpringBootApplication
public class SpringBootDemoApplication {

 

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context  = SpringApplication.run(SpringBootDemoApplication.class, args);
        ProductDatabase database= context.getBean(ProductDatabase.class);
        System.out.println(database.getTemplate());
        
        ProductService service= context.getBean(ProductService.class);
        System.out.println(service.getCount());
        //System.out.println("HI");
    }
}