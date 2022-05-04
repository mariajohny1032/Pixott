package com.revature.fsd.pixott.handler;

import java.util.Scanner;

import com.revature.fsd.pixott.dao.MovieDao;

public class MovieHandler {
	public static void displaymovie() {
		System.out.println("~~~~~~~~~~~");
		System.out.println("Pixott Home");
		System.out.println("~~~~~~~~~~~");
		System.out.println("1. View Top Five Movies");
		System.out.println("2. Search Movie");
		System.out.println("3. Your Wish List");
		System.out.println("4. View History");
		System.out.println("5. Logout");
		System.out.println("\nEnter Option :");
		Scanner scanner = new Scanner(System.in);
		int option = Integer.parseInt(scanner.nextLine());
		if(option ==1) {
			
			MovieDao.topfivemovie();
			displaymovie();
		}
		else if (option == 2) {
			System.out.println("Search the movie name");
			String search =scanner.nextLine();
			MovieDao.searchmovie(search);
			displaymovie();
		
	}
		else if (option == 3) {
			String wishlist = scanner.nextLine();
			MovieDao.showWishList(wishlist);
			displaymovie();
			
		}

}
}