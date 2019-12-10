package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sergiogutierrez.digitalfarmer.entity.Animal;

@Repository
public class AnimalDAOImpl implements AnimalDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public AnimalDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Animal> getAll() {
		
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Create query
		Query<Animal> query = currentSession.createQuery("from Animal", Animal.class);
		
		// Execute query and get result list
		List<Animal> animals = query.getResultList();
		
		// Return results
		return animals;
	}

}
