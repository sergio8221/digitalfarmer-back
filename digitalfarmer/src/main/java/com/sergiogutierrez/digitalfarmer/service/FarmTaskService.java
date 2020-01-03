package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.FarmTask;

public interface FarmTaskService {

	public List<FarmTask> getAll();

	public FarmTask getById(int id);
	
	public List<FarmTask> getByFarmId(int id);

	public void save(FarmTask farmTask);

	public void delete(int id);

}
