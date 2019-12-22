package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.sergiogutierrez.digitalfarmer.entity.Field;

public class FieldDAOImpl implements FieldDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public FieldDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Field> getAll() {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create query
		Query<Field> query = currentSession.createQuery("from Field", Field.class);

		// Execute query and get result list
		List<Field> fields = query.getResultList();

		// Return results
		return fields;
	}

	@Override
	public Field getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the object
		Field field = currentSession.get(Field.class, id);

		// Return results
		return field;
	}

	@Override
	public void save(Field field) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Save object
		currentSession.saveOrUpdate(field);

	}

	@Override
	public void delete(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete object with primary key
		Query query = currentSession.createQuery("delete from Field where id=:objectId");

		query.setParameter("objectId", id);

		query.executeUpdate();

	}

}
