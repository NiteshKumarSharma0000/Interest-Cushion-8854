package com.masai.HouseRentingSystem.service;



import com.masai.HouseRentingSystem.dao.PropertyDAO;
import com.masai.HouseRentingSystem.dao.PropertyDAOImpl;
import com.masai.HouseRentingSystem.exception.NoRecordFoundException;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;

public class PropertyServiceImpl implements PropertyService {

	@Override
	public void updateProperty(Property property) throws SomethingWentWrongException, NoRecordFoundException{
		//Create an object of DAO class here
		PropertyDAO propertyDAO = new PropertyDAOImpl();
		propertyDAO.updateProperty(property);
	}
}
