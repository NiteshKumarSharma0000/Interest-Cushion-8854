package com.masai.HouseRentingSystem.dao;


import com.masai.HouseRentingSystem.entity.Landlord;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;

public interface LandlordDAO {

	void addLandlord(Landlord landlord)throws SomethingWentWrongException;

	void login(String username, String password) throws SomethingWentWrongException;

}
