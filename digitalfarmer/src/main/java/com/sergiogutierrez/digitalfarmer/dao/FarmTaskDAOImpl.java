package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sergiogutierrez.digitalfarmer.entity.FarmTask;

@Repository
public class FarmTaskDAOImpl implements FarmTaskDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public FarmTaskDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<FarmTask> getAll() {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create query
		Query<FarmTask> query = currentSession.createQuery("from FarmTask", FarmTask.class);

		// Execute query and get result list
		List<FarmTask> farmTasks = query.getResultList();

		// Return results
		return farmTasks;
	}

	@Override
	public FarmTask getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the object
		FarmTask farmTask = currentSession.get(FarmTask.class, id);

		// Return results
		return farmTask;
	}

	@Override
	public void save(FarmTask farmTask) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Save object
		currentSession.saveOrUpdate(farmTask);

	}

	@Override
	public void delete(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete object with primary key
		Query query = currentSession.createQuery("delete from FarmTask where id=:objectId");

		query.setParameter("objectId", id);

		query.executeUpdate();

	}

}
