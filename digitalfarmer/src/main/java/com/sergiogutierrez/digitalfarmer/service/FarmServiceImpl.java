package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.FarmDAO;
import com.sergiogutierrez.digitalfarmer.entity.Farm;

@Service
public class FarmServiceImpl implements FarmService {

	private FarmDAO DAO;

	@Autowired
	public FarmServiceImpl(FarmDAO DAO) {
		this.DAO = DAO;
	}

	@Override
	@Transactional
	public List<Farm> getAll() {
		return DAO.getAll();
	}

	@Override
	@Transactional
	public Farm getById(int id) {
		return DAO.getById(id);
	}

	@Override
	@Transactional
	public void save(Farm farm) {
		DAO.save(farm);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
