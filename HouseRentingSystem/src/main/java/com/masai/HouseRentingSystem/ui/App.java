package com.masai.HouseRentingSystem.ui;



import com.masai.HouseRentingSystem.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface RenterService {

	void addRenter(Renter renter)throws SomethingWentWrongException;
	void login(String username, String password)throws SomethingWentWrongException, NoRecordFoundException;

}
