package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Machine;

public interface MachineService {

	public List<Machine> getAll();

	public Machine getById(int id);
	
	public List<Machine> getByFarmId(int id);

	public void save(Machine machine);
	
	public void update(Machine machine);

	public void delete(int id);

}
