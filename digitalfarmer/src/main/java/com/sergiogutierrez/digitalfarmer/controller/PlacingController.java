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

import com.sergiogutierrez.digitalfarmer.entity.Placing;
import com.sergiogutierrez.digitalfarmer.service.PlacingService;

@RestController
@RequestMapping("/api/placings")
public class PlacingController {
	
	private PlacingService placingService;

	@Autowired
	public PlacingController(PlacingService placingService) {
		this.placingService = placingService;
	}

	@GetMapping("/")
	public List<Placing> getAll() {
		return placingService.getAll();
	}

	@GetMapping("/{placingId}")
	public Placing getById(@PathVariable int placingId) {
		Placing placing = placingService.getById(placingId);

		if (placing == null) {
			throw new RuntimeException("Placing id not found - " + placingId);
		}

		return placing;
	}

	@PostMapping("/")
	public Placing add(@RequestBody Placing placing) {
		// Force a save in case an id is passed
		placing.setId(0);

		placingService.save(placing);

		return placing;
	}

	@PutMapping("/")
	public Placing update(@RequestBody Placing placing) {
		placingService.save(placing);

		return placing;
	}

	@DeleteMapping("/{placingId}")
	public int delete(@PathVariable int placingId) {

		Placing placing = placingService.getById(placingId);

		if (placing == null) {
			throw new RuntimeException("Placing id not found - " + placingId);
		}

		placingService.delete(placingId);

		return placingId;
	}

}
