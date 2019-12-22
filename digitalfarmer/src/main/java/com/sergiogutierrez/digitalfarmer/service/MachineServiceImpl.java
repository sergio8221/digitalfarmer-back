package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.MachineDAO;
import com.sergiogutierrez.digitalfarmer.entity.Machine;

@Service
public class MachineServiceImpl implements MachineService {

	private MachineDAO DAO;

	@Autowired
	public MachineServiceImpl(MachineDAO DAO) {
		this.DAO = DAO;
	}

	@Override
	@Transactional
	public List<Machine> getAll() {
		return DAO.getAll();
	}

	@Override
	@Transactional
	public Machine getById(int id) {
		return DAO.getById(id);
	}

	@Override
	@Transactional
	public void save(Machine machine) {
		DAO.save(machine);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
