package com.masai.HouseRentingSystem.ui;




import java.time.LocalDate;
import java.util.Scanner;

import com.masai.HouseRentingSystem.App;
import com.masai.HouseRentingSystem.entity.Landlord;
import com.masai.HouseRentingSystem.exception.NoRecordFoundException;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;
import com.masai.HouseRentingSystem.service.LandlordService;
import com.masai.HouseRentingSystem.service.LandlordServiceImpl;
import com.masai.HouseRentingSystem.service.PropertyService;
import com.masai.HouseRentingSystem.service.PropertyServiceImpl;

public class aLandlordUI {

	public static void registerLandlordAccount(Scanner sc) {
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter date of birth ");
		LocalDate dateOfBirth = LocalDate.parse(sc.next());
		
		//Create an object of customer
		Landlord landlord = new Landlord(name, username, password, dateOfBirth);
		
		try {
			//Create an object of CustomerService
			LandlordService landlordService = new LandlordServiceImpl();
			landlordService.addLandlord(landlord);
			System.out.println("Landlord added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
		
	}

	public static void logInLandlordAccount(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		try {
			LandlordService customerService = new LandlordServiceImpl();
			customerService.login(username, password);
			App.landlordMenu(sc);
		}catch(NoRecordFoundException | SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	

	public static void updatePropertyAndStatus(Scanner sc) {
		System.out.print("Enter id ");
		int id = sc.nextInt();
		System.out.print("Enter Property Name ");
		String propertyName = sc.next();
		System.out.print("Enter Estd Year");
		int estd = sc.nextInt();
		System.out.print("Enter rent amount ");
		double amount = sc.nextDouble();
		System.out.print("Enter location ");
		String location = sc.next();
		System.out.print("Enter property details");
		String propertyDet = sc.next();
		try {
			//get company entity details from company name
			PropertyService propertyService = new PropertyServiceImpl();
//			Property property = propertyService.getPropertyObjectByName(propertyName);
			
			//Create Plan object with updated information
			Property property = new Property(propertyName, estd, amount, location, propertyDet);
			property.setId(id);
			
			propertyService.updateProperty(property);
			System.out.println("Property updated successfully");
		}catch(SomethingWentWrongException | NoRecordFoundException ex){
			System.out.println(ex.getMessage());
		}
	}

	

}
