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

import com.sergiogutierrez.digitalfarmer.entity.CropEvent;
import com.sergiogutierrez.digitalfarmer.entity.Season;
import com.sergiogutierrez.digitalfarmer.service.CropEventService;

@RestController
@RequestMapping("/api/cropEvents")
public class CropEventController {

	private CropEventService cropEventService;

	@Autowired
	public CropEventController(CropEventService cropEventService) {
		this.cropEventService = cropEventService;
	}

	@GetMapping("/")
	public List<CropEvent> getAll() {
		return cropEventService.getAll();
	}

	@GetMapping("/{cropEventId}")
	public CropEvent getById(@PathVariable int cropEventId) {
		CropEvent cropEvent = cropEventService.getById(cropEventId);

		if (cropEvent == null) {
			throw new RuntimeException("CropEvent id not found - " + cropEventId);
		}

		return cropEvent;
	}

	@GetMapping("/season/{seasonId}")
	public List<CropEvent> getBySeasonId(@PathVariable int seasonId) {
		return cropEventService.getBySeasonId(seasonId);
	}

	@PostMapping("/")
	public CropEvent add(@RequestBody CropEvent cropEvent) {
		// Force a save in case an id is passed
		cropEvent.setId(0);

		cropEventService.save(cropEvent);

		return cropEvent;
	}

	@PutMapping("/")
	public CropEvent update(@RequestBody CropEvent cropEvent) {
		cropEventService.update(cropEvent);

		return cropEvent;
	}

	@DeleteMapping("/{cropEventId}")
	public int delete(@PathVariable int cropEventId) {

		CropEvent cropEvent = cropEventService.getById(cropEventId);

		if (cropEvent == null) {
			throw new RuntimeException("CropEvent id not found - " + cropEventId);
		}

		cropEventService.delete(cropEventId);

		return cropEventId;
	}

}
