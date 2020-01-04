package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Field;

public interface FieldService {

	public List<Field> getAll();

	public Field getById(int id);
	
	public List<Field> getByFarmId(int id);

	public void save(Field field);
	
	public void update(Field field);

	public void delete(int id);

}
