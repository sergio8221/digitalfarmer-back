package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.sergiogutierrez.digitalfarmer.entity.Machine;

public class MachineDAOImpl implements MachineDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public MachineDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Machine> getAll() {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create query
		Query<Machine> query = currentSession.createQuery("from Machine", Machine.class);

		// Execute query and get result list
		List<Machine> machines = query.getResultList();

		// Return results
		return machines;
	}

	@Override
	public Machine getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the object
		Machine machine = currentSession.get(Machine.class, id);

		// Return results
		return machine;
	}

	@Override
	public void save(Machine machine) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Save object
		currentSession.saveOrUpdate(machine);

	}

	@Override
	public void delete(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete object with primary key
		Query query = currentSession.createQuery("delete from Machine where id=:objectId");

		query.setParameter("objectId", id);

		query.executeUpdate();

	}

}
