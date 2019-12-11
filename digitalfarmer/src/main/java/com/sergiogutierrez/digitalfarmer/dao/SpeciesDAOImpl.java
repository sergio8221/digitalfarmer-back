package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.sergiogutierrez.digitalfarmer.entity.Species;

public class SpeciesDAOImpl implements SpeciesDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public SpeciesDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Species> getAll() {

		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create query
		Query<Species> query = currentSession.createQuery("from Species", Species.class);

		// Execute query and get result list
		List<Species> species = query.getResultList();

		// Return results
		return species;
	}

	@Override
	public Species getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the object
		Species species = currentSession.get(Species.class, id);

		// Return results
		return species;
	}

}
