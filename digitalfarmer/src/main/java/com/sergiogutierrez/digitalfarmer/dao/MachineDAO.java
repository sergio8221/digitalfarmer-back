package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Machine;

public interface MachineDAO {

	public List<Machine> getAll();

	public Machine getById(int id);

	public void save(Machine machine);

	public void delete(int id);

}
