package com.sergiogutierrez.digitalfarmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiogutierrez.digitalfarmer.dao.AnimalDAO;
import com.sergiogutierrez.digitalfarmer.entity.Animal;

@RestController
@RequestMapping("/api")
public class AnimalController {

	private AnimalDAO animalDAO;

	// Inject Animal dao
	@Autowired
	public AnimalController(AnimalDAO theAnimalDAO) {
		animalDAO = theAnimalDAO;
	}

	// Expose /animals
	@GetMapping("/animals")
	public List<Animal> getAll() {
		return animalDAO.getAll();
	}

}
