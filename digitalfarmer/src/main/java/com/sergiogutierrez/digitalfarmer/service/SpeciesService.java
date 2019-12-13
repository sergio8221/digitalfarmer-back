package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Species;

public interface SpeciesService {

	public List<Species> getAll();

	public Species getById(int id);

}
