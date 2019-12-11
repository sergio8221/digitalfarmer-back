package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sergiogutierrez.digitalfarmer.dao.SpeciesDAO;
import com.sergiogutierrez.digitalfarmer.entity.Species;

public class SpeciesServiceImpl implements SpeciesService {

	private SpeciesDAO speciesDAO;

	@Autowired
	public SpeciesServiceImpl(SpeciesDAO speciesDAO) {
		this.speciesDAO = speciesDAO;
	}

	@Override
	public List<Species> getAll() {
		return speciesDAO.getAll();
	}

	@Override
	public Species getById(int id) {
		return speciesDAO.getById(id);
	}

}
