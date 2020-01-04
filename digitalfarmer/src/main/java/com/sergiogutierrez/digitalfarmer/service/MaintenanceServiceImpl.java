package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.MachineDAO;
import com.sergiogutierrez.digitalfarmer.dao.MaintenanceDAO;
import com.sergiogutierrez.digitalfarmer.entity.Machine;
import com.sergiogutierrez.digitalfarmer.entity.Maintenance;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

	private MaintenanceDAO DAO;

	@Autowired
	public MaintenanceServiceImpl(MaintenanceDAO DAO) {
		this.DAO = DAO;
	}

	@Autowired
	private MachineDAO machineDAO;

	@Override
	public List<Maintenance> getAll() {
		return DAO.getAll();
	}

	@Override
	public Maintenance getById(int id) {
		return DAO.getById(id);
	}

	@Override
	public List<Maintenance> getByMachineId(int id) {
		Machine machine = machineDAO.getById(id);

		return machine.getMaintenances();
	}

	@Override
	public void save(Maintenance maintenance) {
		DAO.save(maintenance);

	}

	@Override
	@Transactional
	public void update(Maintenance maintenance) {
		Maintenance mainToUpdate = DAO.getById(maintenance.getId());

		mainToUpdate.setDescription(maintenance.getDescription());
		mainToUpdate.setDate(maintenance.getDate());

		DAO.save(mainToUpdate);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
