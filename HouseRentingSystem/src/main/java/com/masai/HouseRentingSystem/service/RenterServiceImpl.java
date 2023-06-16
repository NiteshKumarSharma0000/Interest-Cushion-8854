package com.masai.HouseRentingSystem.service;



import com.masai.HouseRentingSystem.entity.Renter;
import com.masai.HouseRentingSystem.exception.NoRecordFoundException;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;

public interface RenterService {

	void addRenter(Renter renter)throws SomethingWentWrongException;
	void login(String username, String password)throws SomethingWentWrongException, NoRecordFoundException;

}
