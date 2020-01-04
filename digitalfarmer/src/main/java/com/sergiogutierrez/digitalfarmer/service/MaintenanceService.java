package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Maintenance;

public interface MaintenanceService {

	public List<Maintenance> getAll();

	public Maintenance getById(int id);
	
	public List<Maintenance> getByMachineId(int id);

	public void save(Maintenance maintenance);

	public void update(Maintenance maintenance);
	
	public void delete(int id);

}
