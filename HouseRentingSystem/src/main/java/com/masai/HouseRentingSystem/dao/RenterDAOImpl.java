package com.masai.HouseRentingSystem.dao;


import java.util.List;

import com.masai.HouseRentingSystem.entity.LoggedInUserId;
import com.masai.HouseRentingSystem.entity.Renter;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;
import com.masai.HouseRentingSystem.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class RenterDAOImpl implements RenterDAO{

	@Override
	public void addRenter(Renter renter) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			//check if company with same username exists
			Query query = em.createQuery("SELECT count(r) FROM Renter r WHERE username = :username");
			query.setParameter("username", renter.getUsername());
			if((Long)query.getSingleResult() > 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomethingWentWrongException("The username" + renter.getUsername() + " is already occupied");
			}
			
			//you are here means no company with given name
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(renter);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void login(String username, String password) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			Query query = em.createQuery("SELECT r.id FROM Renter r WHERE username = :username AND password = :password AND isDeleted = 0");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Integer> listInt = (List<Integer>)query.getResultList();
			if(listInt.size() == 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomethingWentWrongException("The username or password is incorrect");
			}
			LoggedInUserId.loggedInUserId = listInt.get(0);
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

}
