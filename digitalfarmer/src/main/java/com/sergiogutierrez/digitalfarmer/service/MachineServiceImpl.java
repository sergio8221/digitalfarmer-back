package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.FarmDAO;
import com.sergiogutierrez.digitalfarmer.dao.MachineDAO;
import com.sergiogutierrez.digitalfarmer.entity.Farm;
import com.sergiogutierrez.digitalfarmer.entity.Machine;

@Service
public class MachineServiceImpl implements MachineService {

	private MachineDAO DAO;

	@Autowired
	public MachineServiceImpl(MachineDAO DAO) {
		this.DAO = DAO;
	}

	@Autowired
	private FarmDAO farmDAO;

	@Override
	public List<Machine> getAll() {
		return DAO.getAll();
	}

	@Override
	public Machine getById(int id) {
		return DAO.getById(id);
	}

	@Override
	public List<Machine> getByFarmId(int id) {
		Farm farm = farmDAO.getById(id);

		return farm.getMachines();
	}

	@Override
	public void save(Machine machine) {
		DAO.save(machine);

	}

	@Override
	@Transactional
	public void update(Machine machine) {
		Machine machineToUpdate = DAO.getById(machine.getId());

		machineToUpdate.setName(machine.getName());
		machineToUpdate.setAdquisition(machine.getAdquisition());
		machineToUpdate.setCost(machine.getCost());

		DAO.save(machineToUpdate);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
