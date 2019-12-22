package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.UserDAO;
import com.sergiogutierrez.digitalfarmer.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO DAO;

	@Autowired
	public UserServiceImpl(UserDAO DAO) {
		this.DAO = DAO;
	}

	@Override
	@Transactional
	public List<User> getAll() {
		return DAO.getAll();
	}

	@Override
	@Transactional
	public User getById(int id) {
		return DAO.getById(id);
	}

	@Override
	@Transactional
	public void save(User user) {
		DAO.save(user);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
