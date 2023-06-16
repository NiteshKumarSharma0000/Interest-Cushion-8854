package com.masai.HouseRentingSystem.service;



import com.masai.HouseRentingSystem.dao.LandlordDAO;
import com.masai.HouseRentingSystem.dao.LandlordDAOImpl;
import com.masai.HouseRentingSystem.entity.Landlord;
import com.masai.HouseRentingSystem.exception.NoRecordFoundException;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;

public class LandlordServiceImpl implements LandlordService{

	@Override
	public void addLandlord(Landlord customer) throws SomethingWentWrongException {
		//Create an object of CustomerDAO
		LandlordDAO landLordDAO = new LandlordDAOImpl();
		landLordDAO.addLandlord(customer);
	}
	
	@Override
	public void login(String username, String password) 
			throws SomethingWentWrongException, NoRecordFoundException{
		//Create an object of CustomerDAO
		LandlordDAO customerDAO = new LandlordDAOImpl();
		customerDAO.login(username, password);		
	}
}
