package com.masai.HouseRentingSystem.dao;

import com.masai.HouseRentingSystem.exception.NoRecordFoundException;
import com.masai.HouseRentingSystem.exception.SomethingWentWrongException;
import com.masai.HouseRentingSystem.utility.EMUtils;
import com.masai.exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class PropertyDAOImpl implements PropertyDAO {

	public void updateProperty(Property property) throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			Property propertyFromDB = em.find(Property.class, property.getId());
			if (propertyFromDB == null)
				throw new NoRecordFoundException("No Property found with the given id " + property.getId());

			if (!propertyFromDB.getPropertyName().equals(property.getPropertyName())) {
				
				Query query = em.createQuery("SELECT count(p) FROM Property p WHERE propertyName = :propertyName");
				query.setParameter("companyName", property.getPropertyName());
				if ((Long) query.getSingleResult() > 0) {
					
					throw new SomethingWentWrongException(
							"Company already exists with name " + property.getPropertyName());
				}
			}

			

			EntityTransaction et = em.getTransaction();
			et.begin();
			propertyFromDB.setPropertyName(property.getPropertyName());
			propertyFromDB.setEstdYear(property.getEstdYear());
			propertyFromDB.setLocation(property.getLocation());
			propertyFromDB.setDetails(property.getDetails());
			propertyFromDB.setAmount(property.getAmount());
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
	}
}
