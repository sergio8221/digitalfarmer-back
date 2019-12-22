package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sergiogutierrez.digitalfarmer.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<User> getAll() {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create query
		Query<User> query = currentSession.createQuery("from User", User.class);

		// Execute query and get result list
		List<User> users = query.getResultList();

		// Return results
		return users;
	}

	@Override
	public User getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the object
		User user = currentSession.get(User.class, id);

		// Return results
		return user;
	}

	@Override
	public void save(User user) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Save object
		currentSession.saveOrUpdate(user);

	}

	@Override
	public void delete(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete object with primary key
		Query query = currentSession.createQuery("delete from User where id=:objectId");

		query.setParameter("objectId", id);

		query.executeUpdate();

	}

}
