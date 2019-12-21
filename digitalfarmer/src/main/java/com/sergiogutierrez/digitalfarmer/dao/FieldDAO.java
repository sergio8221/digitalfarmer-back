package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Field;

public interface FieldDAO {

	public List<Field> getAll();

	public Field getById(int id);

	public void save(Field field);

	public void delete(int id);

}
