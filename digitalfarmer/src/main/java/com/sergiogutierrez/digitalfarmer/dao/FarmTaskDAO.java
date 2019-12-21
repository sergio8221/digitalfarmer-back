package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.FarmTask;

public interface FarmTaskDAO {

	public List<FarmTask> getAll();

	public FarmTask getById(int id);

	public void save(FarmTask farmTask);

	public void delete(int id);

}
