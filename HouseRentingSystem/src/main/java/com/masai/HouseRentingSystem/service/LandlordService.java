package com.masai.HouseRentingSystem.service;



import com.masai.HouseRentingSystem.entity.Landlord;
import com.masai.HouseRentingSystem.exception.NoRecordFoundException;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;

public interface LandlordService {
	void addLandlord(Landlord landLord) throws SomethingWentWrongException;

	void login(String username, String password)throws SomethingWentWrongException, NoRecordFoundException;

}
