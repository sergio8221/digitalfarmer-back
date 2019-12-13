package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sergiogutierrez.digitalfarmer.entity.Placing;

@Repository
public class PlacingDAOImpl implements PlacingDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public PlacingDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Placing> getAll() {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create query
		Query<Placing> query = currentSession.createQuery("from Placing", Placing.class);

		// Execute query and get result list
		List<Placing> placings = query.getResultList();

		// Return results
		return placings;
	}

	@Override
	public Placing getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the object
		Placing placing = currentSession.get(Placing.class, id);

		// Return results
		return placing;
	}

	@Override
	public void save(Placing placing) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Save object
		currentSession.saveOrUpdate(placing);

	}

	@Override
	public void delete(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete object with primary key
		Query query = currentSession.createQuery("delete from Placing where id=:placingId");

		query.setParameter("placingId", id);

		query.executeUpdate();

	}

}
