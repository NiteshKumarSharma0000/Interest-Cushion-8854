package com.masai.HouseRentingSystem.dao;



import com.masai.HouseRentingSystem.entity.Renter;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;

public interface RenterDAO {

	void addRenter(Renter renter) throws SomethingWentWrongException;
	void login(String username, String password) throws SomethingWentWrongException;
}
