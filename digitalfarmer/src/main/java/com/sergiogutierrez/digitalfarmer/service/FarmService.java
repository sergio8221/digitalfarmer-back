package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Farm;

public interface FarmService {

	public List<Farm> getAll();

	public Farm getById(int id);

	public Farm getByUserId(int id);

	public void save(Farm farm);

	public void update(Farm farm);

	public void delete(int id);

}
