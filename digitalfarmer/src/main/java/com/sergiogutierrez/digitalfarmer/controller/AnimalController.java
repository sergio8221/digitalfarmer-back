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
@RequestMapping("/api/animals")
public class AnimalController {

	private AnimalService animalService;

	@Autowired
	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping("/")
	public List<Animal> getAll() {
		return animalService.getAll();
	}

	@GetMapping("/{animalId}")
	public Animal getById(@PathVariable int animalId) {
		Animal animal = animalService.getById(animalId);

		if (animal == null) {
			throw new RuntimeException("Animal id not found - " + animalId);
		}

		return animal;
	}

	@PostMapping("/")
	public Animal add(@RequestBody Animal animal) {
		// Force a save in case an id is passed
		animal.setId(0);

		animalService.save(animal);

		return animal;
	}

	@PutMapping("/")
	public Animal update(@RequestBody Animal animal) {
		animalService.update(animal);

		return animal;
	}

	@DeleteMapping("/{animalId}")
	public int delete(@PathVariable int animalId) {

		Animal animal = animalService.getById(animalId);

		if (animal == null) {
			throw new RuntimeException("Animal id not found - " + animalId);
		}

		animalService.delete(animalId);

		return animalId;
	}

}
