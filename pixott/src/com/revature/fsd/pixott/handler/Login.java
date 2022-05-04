package com.revature.fsd.pixott.handler;

import com.revature.fsd.pixott.Customer;
import com.revature.fsd.pixott.dao.CustomerDao;

public class Login {
public static void display() {
	System.out.println("mobilenumber");
	String mobile = App.scanner.next();
	System.out.println("password");
	String password = App.scanner.next();
	CustomerDao sign = new CustomerDao();
	Customer up = new Customer();
	up.setMobile(mobile);
	up.setPassword(password);
	sign.getcustomer(mobile);
	//System.out.println(up.getName());
	MovieHandler.displaymovie();
	
	
}
}



