package com.masai.HouseRentingSystem.dao;



import com.masai.HouseRentingSystem.exception.NoRecordFoundException;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;

public interface PropertyDAO {
	void updateProperty(Property property) throws SomethingWentWrongException, NoRecordFoundException;
}
