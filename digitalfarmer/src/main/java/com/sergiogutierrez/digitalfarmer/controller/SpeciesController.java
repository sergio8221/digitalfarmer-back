package com.sergiogutierrez.digitalfarmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiogutierrez.digitalfarmer.entity.Species;
import com.sergiogutierrez.digitalfarmer.service.SpeciesService;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {

	private SpeciesService speciesService;

	@Autowired
	public SpeciesController(SpeciesService speciesService) {
		this.speciesService = speciesService;
	}

	@GetMapping("/")
	public List<Species> getAll() {
		return speciesService.getAll();
	}

	@GetMapping("/{speciesId}")
	public Species getById(@PathVariable int speciesId) {
		Species species = speciesService.getById(speciesId);

		if (species == null) {
			throw new RuntimeException("Species id not found - " + speciesId);
		}

		return species;
	}

}
