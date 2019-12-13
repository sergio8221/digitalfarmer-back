package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Placing;

public interface PlacingDAO {

	public List<Placing> getAll();

	public Placing getById(int id);

	public void save(Placing placing);

	public void delete(int id);

}
