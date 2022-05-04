package com.revature.fsd.pixott.handler;

import java.util.Scanner;

public class MainMenuHandler {
	public static void display() {
		System.out.println("----------");
		System.out.println("Pixott");
		System.out.println("Main Menu\n----------\n");
		System.out.println("1. SignUp");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		System.out.println("\nEnter Option :");
		Scanner scanner = new Scanner(System.in);
		int option = Integer.parseInt(scanner.next());
		if (option==1) {
			SignUpHandler.displaySignUp();
		}
		else if (option==2) {
			Login.display();
		}
	}

}
