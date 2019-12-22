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

import com.sergiogutierrez.digitalfarmer.entity.Season;
import com.sergiogutierrez.digitalfarmer.service.SeasonService;

@RestController
@RequestMapping("/api/seasons")
public class SeasonController {

	private SeasonService seasonService;

	@Autowired
	public SeasonController(SeasonService seasonService) {
		this.seasonService = seasonService;
	}

	@GetMapping("/")
	public List<Season> getAll() {
		return seasonService.getAll();
	}

	@GetMapping("/{seasonId}")
	public Season getById(@PathVariable int seasonId) {
		Season season = seasonService.getById(seasonId);

		if (season == null) {
			throw new RuntimeException("Season id not found - " + seasonId);
		}

		return season;
	}

	@PostMapping("/")
	public Season add(@RequestBody Season season) {
		// Force a save in case an id is passed
		season.setId(0);

		seasonService.save(season);

		return season;
	}

	@PutMapping("/")
	public Season update(@RequestBody Season season) {
		seasonService.save(season);

		return season;
	}

	@DeleteMapping("/{seasonId}")
	public int delete(@PathVariable int seasonId) {

		Season season = seasonService.getById(seasonId);

		if (season == null) {
			throw new RuntimeException("Season id not found - " + seasonId);
		}

		seasonService.delete(seasonId);

		return seasonId;
	}

}
