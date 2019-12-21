package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Maintenance;

public interface MaintenanceDAO {

	public List<Maintenance> getAll();

	public Maintenance getById(int id);

	public void save(Maintenance maintenance);

	public void delete(int id);

}
