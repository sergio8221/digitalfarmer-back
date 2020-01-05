package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.FarmDAO;
import com.sergiogutierrez.digitalfarmer.dao.UserDAO;
import com.sergiogutierrez.digitalfarmer.entity.Farm;
import com.sergiogutierrez.digitalfarmer.entity.User;

@Service
public class FarmServiceImpl implements FarmService {

	private FarmDAO DAO;

	@Autowired
	public FarmServiceImpl(FarmDAO DAO) {
		this.DAO = DAO;
	}

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<Farm> getAll() {
		return DAO.getAll();
	}

	@Override
	public Farm getById(int id) {
		return DAO.getById(id);
	}

	@Override
	public Farm getByUserId(int id) {
		User user = userDAO.getById(id);

		return user.getFarm();
	}

	@Override
	public void save(Farm farm) {
		DAO.save(farm);

	}

	@Override
	@Transactional
	public void update(Farm farm) {
		Farm farmToUpdate = DAO.getById(farm.getId());

		farmToUpdate.setLocation(farm.getLocation());

		DAO.save(farmToUpdate);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
