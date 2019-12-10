package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
	public AnimalDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
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

	@Override
	public Animal getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the animal
		Animal animal = currentSession.get(Animal.class, id);

		// Return results
		return animal;
	}

	@Override
	public void save(Animal animal) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Save animal
		currentSession.saveOrUpdate(animal);

	}

	@Override
	public void delete(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete object with primary key
		Query query = currentSession.createQuery("delete from Animal where id=:animalId");

		query.setParameter("animalId", id);

		query.executeUpdate();

	}

}
