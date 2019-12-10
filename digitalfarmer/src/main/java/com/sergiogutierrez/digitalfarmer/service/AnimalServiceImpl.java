package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.AnimalDAO;
import com.sergiogutierrez.digitalfarmer.entity.Animal;

@Service
public class AnimalServiceImpl implements AnimalService {

	private AnimalDAO animalDAO;

	@Autowired
	public AnimalServiceImpl(AnimalDAO animalDAO) {
		this.animalDAO = animalDAO;
	}

	@Override
	@Transactional
	public List<Animal> getAll() {
		return animalDAO.getAll();
	}

	@Override
	@Transactional
	public Animal getById(int id) {
		return animalDAO.getById(id);
	}

	@Override
	@Transactional
	public void save(Animal animal) {
		animalDAO.save(animal);
	}

	@Override
	@Transactional
	public void delete(int id) {
		animalDAO.delete(id);
	}

}
