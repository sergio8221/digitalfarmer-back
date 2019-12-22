package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.sergiogutierrez.digitalfarmer.entity.Maintenance;

public class MaintenanceDAOImpl implements MaintenanceDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public MaintenanceDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Maintenance> getAll() {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create query
		Query<Maintenance> query = currentSession.createQuery("from Maintenance", Maintenance.class);

		// Execute query and get result list
		List<Maintenance> maintenances = query.getResultList();

		// Return results
		return maintenances;
	}

	@Override
	public Maintenance getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the object
		Maintenance maintenance = currentSession.get(Maintenance.class, id);

		// Return results
		return maintenance;
	}

	@Override
	public void save(Maintenance maintenance) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Save object
		currentSession.saveOrUpdate(maintenance);

	}

	@Override
	public void delete(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete object with primary key
		Query query = currentSession.createQuery("delete from Maintenance where id=:objectId");

		query.setParameter("objectId", id);

		query.executeUpdate();

	}

}
