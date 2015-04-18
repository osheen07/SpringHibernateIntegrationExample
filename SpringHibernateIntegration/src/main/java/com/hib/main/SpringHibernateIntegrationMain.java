package com.hib.main;

import java.util.List;
 


import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hib.DAO.CustomerDAO;
import com.hib.model.Customer;
 
 
public class SpringHibernateIntegrationMain {
 
    public static void main(String[] args) {
 
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
         
        CustomerDAO cd = context.getBean(CustomerDAO.class);
         
        Customer cust = new Customer();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter First Name: ");
        String fname = sc.next();
        cust.setFirstName(fname);
        
        System.out.println("Enter Last Name: ");
        String lname = sc.next();
        cust.setLastName("lname");
        
        System.out.println("Enter Amount: ");
        int amnt = sc.nextInt();
        cust.setAmount(amnt);
        
        cd.save(cust);
         
        System.out.println("New Customer: "+cust);
         
        List<Customer> list = cd.list();
         
        for(Customer c : list){
            System.out.println("Customers List: "+c);
        }
        //close resources
        context.close();    
    }
}