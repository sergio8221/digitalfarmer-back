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

import com.sergiogutierrez.digitalfarmer.entity.Farm;
import com.sergiogutierrez.digitalfarmer.service.FarmService;

@RestController
@RequestMapping("/api/farms")
public class FarmController {

	private FarmService farmService;

	@Autowired
	public FarmController(FarmService farmService) {
		this.farmService = farmService;
	}

	@GetMapping("/")
	public List<Farm> getAll() {
		return farmService.getAll();
	}

	@GetMapping("/{farmId}")
	public Farm getById(@PathVariable int farmId) {
		Farm farm = farmService.getById(farmId);

		if (farm == null) {
			throw new RuntimeException("Farm id not found - " + farmId);
		}

		return farm;
	}

	@GetMapping("/user/{userId}")
	public Farm getByUserId(@PathVariable int userId) {
		return farmService.getByUserId(userId);
	}

	@PostMapping("/")
	public Farm add(@RequestBody Farm farm) {
		// Force a save in case an id is passed
		farm.setId(0);

		farmService.save(farm);

		return farm;
	}

	@PutMapping("/")
	public Farm update(@RequestBody Farm farm) {
		farmService.update(farm);

		return farm;
	}

	@DeleteMapping("/{farmId}")
	public int delete(@PathVariable int farmId) {

		Farm farm = farmService.getById(farmId);

		if (farm == null) {
			throw new RuntimeException("Farm id not found - " + farmId);
		}

		farmService.delete(farmId);

		return farmId;
	}

}
