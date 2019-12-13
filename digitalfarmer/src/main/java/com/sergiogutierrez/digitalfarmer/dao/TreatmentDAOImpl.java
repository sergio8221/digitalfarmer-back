package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sergiogutierrez.digitalfarmer.entity.Treatment;

@Repository
public class TreatmentDAOImpl implements TreatmentDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public TreatmentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Treatment> getAll() {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create query
		Query<Treatment> query = currentSession.createQuery("from Treatment", Treatment.class);

		// Execute query and get result list
		List<Treatment> treatments = query.getResultList();

		// Return results
		return treatments;
	}

	@Override
	public Treatment getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the object
		Treatment treatment = currentSession.get(Treatment.class, id);

		// Return results
		return treatment;
	}

	@Override
	public void save(Treatment treatment) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Save object
		currentSession.saveOrUpdate(treatment);

	}

	@Override
	public void delete(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete object with primary key
		Query query = currentSession.createQuery("delete from Treatment where id=:treatmentId");

		query.setParameter("treatmentId", id);

		query.executeUpdate();

	}

}
