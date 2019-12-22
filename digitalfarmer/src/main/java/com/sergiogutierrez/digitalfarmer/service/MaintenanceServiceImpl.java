package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.MaintenanceDAO;
import com.sergiogutierrez.digitalfarmer.entity.Maintenance;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

	private MaintenanceDAO DAO;

	@Autowired
	public MaintenanceServiceImpl(MaintenanceDAO DAO) {
		this.DAO = DAO;
	}

	@Override
	@Transactional
	public List<Maintenance> getAll() {
		return DAO.getAll();
	}

	@Override
	@Transactional
	public Maintenance getById(int id) {
		return DAO.getById(id);
	}

	@Override
	@Transactional
	public void save(Maintenance maintenance) {
		DAO.save(maintenance);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
