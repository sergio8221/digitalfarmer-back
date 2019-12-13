package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Species;

public interface SpeciesDAO {

	public List<Species> getAll();

	public Species getById(int id);

}
