package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sergiogutierrez.digitalfarmer.entity.CropEvent;

@Repository
public class CropEventDAOImpl implements CropEventDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public CropEventDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<CropEvent> getAll() {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create query
		Query<CropEvent> query = currentSession.createQuery("from CropEvent", CropEvent.class);

		// Execute query and get result list
		List<CropEvent> cropEvents = query.getResultList();

		// Return results
		return cropEvents;
	}

	@Override
	public CropEvent getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the object
		CropEvent cropEvent = currentSession.get(CropEvent.class, id);

		// Return results
		return cropEvent;
	}

	@Override
	public void save(CropEvent cropEvent) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Save object
		currentSession.saveOrUpdate(cropEvent);

	}

	@Override
	public void delete(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete object with primary key
		Query query = currentSession.createQuery("delete from CropEvent where id=:objectId");

		query.setParameter("objectId", id);

		query.executeUpdate();

	}

}
