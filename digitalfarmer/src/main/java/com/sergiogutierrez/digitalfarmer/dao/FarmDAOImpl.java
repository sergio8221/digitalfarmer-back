package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sergiogutierrez.digitalfarmer.entity.Farm;

@Repository
public class FarmDAOImpl implements FarmDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public FarmDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Farm> getAll() {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create query
		Query<Farm> query = currentSession.createQuery("from Farm", Farm.class);

		// Execute query and get result list
		List<Farm> farms = query.getResultList();

		// Return results
		return farms;
	}

	@Override
	public Farm getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the object
		Farm farm = currentSession.get(Farm.class, id);

		// Return results
		return farm;
	}

	@Override
	public void save(Farm farm) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Save object
		currentSession.saveOrUpdate(farm);

	}

	@Override
	public void delete(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete object with primary key
		Query query = currentSession.createQuery("delete from Farm where id=:objectId");

		query.setParameter("objectId", id);

		query.executeUpdate();

	}

}
