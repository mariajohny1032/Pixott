package com.revature.fsd.pixott.handler;

import java.util.Scanner;

import com.revature.fsd.pixott.Customer;
import com.revature.fsd.pixott.dao.CustomerDao;

public class SignUpHandler {
	public static void displaySignUp() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Name");
		String name = scanner.nextLine();
		System.out.println("Mobilenumber");
		String mobilenumber = scanner.nextLine();
		System.out.println("Password");
		String password = scanner.nextLine();
		CustomerDao dao = new CustomerDao();
		Customer customer = new Customer();
		customer.setName(name);
		customer.setMobile(mobilenumber);
		customer.setPassword(password);
		dao.signup(customer);
		MainMenuHandler.display();
		
		
	}

}
