package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.FarmDAO;
import com.sergiogutierrez.digitalfarmer.dao.FarmTaskDAO;
import com.sergiogutierrez.digitalfarmer.entity.Farm;
import com.sergiogutierrez.digitalfarmer.entity.FarmTask;

@Service
public class FarmTaskServiceImpl implements FarmTaskService {

	private FarmTaskDAO DAO;

	@Autowired
	public FarmTaskServiceImpl(FarmTaskDAO DAO) {
		this.DAO = DAO;
	}

	@Autowired
	private FarmDAO farmDAO;

	@Override
	@Transactional
	public List<FarmTask> getAll() {
		return DAO.getAll();
	}

	@Override
	@Transactional
	public FarmTask getById(int id) {
		return DAO.getById(id);
	}

	@Override
	public List<FarmTask> getByFarmId(int id) {
		Farm farm = farmDAO.getById(id);

		return farm.getTasks();
	}

	@Override
	@Transactional
	public void save(FarmTask farmTask) {
		DAO.save(farmTask);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
