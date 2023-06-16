package com.masai.HouseRentingSystem.ui;


import java.time.LocalDate;
import java.util.Scanner;

import com.masai.HouseRentingSystem.entity.LoggedInUserId;
import com.masai.HouseRentingSystem.entity.Renter;
import com.masai.HouseRentingSystem.exception.NoRecordFoundException;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;
import com.masai.service.RenterServiceImpl;

public class RenterUI {

	static void renterRegistration(Scanner sc) {
		//code to take input
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter date of birth ");
		LocalDate dateOfBirth = LocalDate.parse(sc.next());
		
		
		//Create an object of customer
		Renter renter = new Renter(name, username, password, dateOfBirth);
		
		try {
			//Create an object of CustomerService
			RenterService renterService = new RenterServiceImpl();
			renterService.addRenter(renter);
			System.out.println("Renter added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	static void displayRenterMenu() {
		System.out.println("1. Search for available houses");
		System.out.println("2. View information about the listed houses");
		System.out.println("3. Filters to refine the search results");
		System.out.println("4. Submit rental offers to the owners for desired properties");
		System.out.println("5. Track the status of their offers");
		System.out.println("6. View updates on the progress of the rental process");
		System.out.println("0. Logout");
	}
	
	static void renterMenu(Scanner sc) {
		int choice = 0;
		do {
			displayRenterMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				//this code is same as we have used on the admin side
    				//so we are using here as it is
    				AdminUI.viewPlan();
    				break;
    			case 2:
    				calculatePolicyPremium(sc);
    				break;
    			case 3:
    				//code to purchase a new policy
    				purchaseNewPolicy(sc);
    				break;
    			case 4:
    				//code to view policies purchased by logged in user
    				viewPurchasedPolicies();
    				break;
    			case 5:
    				renewPolicies(sc);
    				break;
    			case 6:
    				changePassword(sc);
    				break;
    			case 7:
    				deleteAccount(sc);
    				System.out.println("Logging you out");
    				choice = 0;
    			case 0:
    				LoggedInUserId.loggedInUserId = -1;	
    				System.out.println("Bye Bye User");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
	}
	
	static void renterLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		try {
			RenterService renterService = new RenterServiceImpl();
			renterService.login(username, password);
			renterMenu(sc);
		}catch(NoRecordFoundException | SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
