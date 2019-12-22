package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.sergiogutierrez.digitalfarmer.entity.Season;

public class SeasonDAOImpl implements SeasonDAO {

	// Define field for entity manager
	private EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public SeasonDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Season> getAll() {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create query
		Query<Season> query = currentSession.createQuery("from Season", Season.class);

		// Execute query and get result list
		List<Season> seasons = query.getResultList();

		// Return results
		return seasons;
	}

	@Override
	public Season getById(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the object
		Season season = currentSession.get(Season.class, id);

		// Return results
		return season;
	}

	@Override
	public void save(Season season) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Save object
		currentSession.saveOrUpdate(season);

	}

	@Override
	public void delete(int id) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Delete object with primary key
		Query query = currentSession.createQuery("delete from Season where id=:objectId");

		query.setParameter("objectId", id);

		query.executeUpdate();

	}

}
