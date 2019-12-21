package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Farm;

public interface FarmDAO {

	public List<Farm> getAll();

	public Farm getById(int id);

	public void save(Farm farm);

	public void delete(int id);

}
