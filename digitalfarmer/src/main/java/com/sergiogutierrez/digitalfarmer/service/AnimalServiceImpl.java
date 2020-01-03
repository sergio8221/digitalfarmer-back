package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.AnimalDAO;
import com.sergiogutierrez.digitalfarmer.dao.PlacingDAO;
import com.sergiogutierrez.digitalfarmer.dao.SpeciesDAO;
import com.sergiogutierrez.digitalfarmer.entity.Animal;
import com.sergiogutierrez.digitalfarmer.entity.Placing;
import com.sergiogutierrez.digitalfarmer.entity.Species;

@Service
public class AnimalServiceImpl implements AnimalService {

	private AnimalDAO animalDAO;

	@Autowired
	public AnimalServiceImpl(AnimalDAO animalDAO) {
		this.animalDAO = animalDAO;
	}
	
	@Autowired
	private PlacingDAO placingDAO;

	@Autowired
	private SpeciesDAO speciesDAO;

	@Override
	public List<Animal> getAll() {
		return animalDAO.getAll();
	}

	@Override
	public Animal getById(int id) {
		return animalDAO.getById(id);
	}

	@Override
	public void save(Animal animal) {
		animalDAO.save(animal);
	}

	@Override
	@Transactional
	public void update(Animal animal) {
		Placing placingToSet = placingDAO.getById(animal.getPlacing().getId());

		Species speciesToSet = speciesDAO.getById(animal.getSpecies().getId());

		Animal animalToUpdate = animalDAO.getById(animal.getId());

		animalToUpdate.setName(animal.getName());
		animalToUpdate.setCode(animal.getCode());
		animalToUpdate.setBorn(animal.getBorn());
		animalToUpdate.setSex(animal.getSex());
		animalToUpdate.setPlacing(placingToSet);
		animalToUpdate.setSpecies(speciesToSet);

		animalDAO.save(animalToUpdate);

	}

	@Override
	@Transactional
	public void delete(int id) {
		animalDAO.delete(id);
	}

}
