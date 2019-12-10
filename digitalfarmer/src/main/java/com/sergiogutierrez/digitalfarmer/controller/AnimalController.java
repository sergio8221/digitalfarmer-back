package com.sergiogutierrez.digitalfarmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiogutierrez.digitalfarmer.entity.Animal;
import com.sergiogutierrez.digitalfarmer.service.AnimalService;

@RestController
@RequestMapping("/api")
public class AnimalController {

	private AnimalService animalService;

	@Autowired
	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping("/animals")
	public List<Animal> getAll() {
		return animalService.getAll();
	}

	@GetMapping("/animal/{animalId}")
	public Animal getById(@PathVariable int animalId) {
		Animal animal = animalService.getById(animalId);

		if (animal == null) {
			throw new RuntimeException("Animal id not found - " + animalId);
		}

		return animal;
	}

	@PostMapping("/animal")
	public Animal addAnimal(@RequestBody Animal animal) {
		// Force a save in case an id is passed
		animal.setId(0);

		animalService.save(animal);

		return animal;
	}

	@PutMapping("/animal")
	public Animal updateAnimal(@RequestBody Animal animal) {
		animalService.save(animal);

		return animal;
	}

	@DeleteMapping("/animal/{animalId}")
	public int deleteAnimal(@PathVariable int animalId) {

		Animal animal = animalService.getById(animalId);

		if (animal == null) {
			throw new RuntimeException("Animal id not found - " + animalId);
		}

		animalService.delete(animalId);

		return animalId;
	}

}
