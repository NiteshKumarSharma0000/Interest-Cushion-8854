package com.masai.HouseRentingSystem.service;



import com.masai.HouseRentingSystem.exception.NoRecordFoundException;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;

public interface PropertyService {

	void updateProperty(Property property) throws SomethingWentWrongException, NoRecordFoundException;
}
