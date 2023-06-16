package com.masai.HouseRentingSystem.dao;



import com.masai.HouseRentingSystem.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;

public interface PropertyDAO {
	void updateProperty(Property property) throws SomethingWentWrongException, NoRecordFoundException;
}
