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

import com.sergiogutierrez.digitalfarmer.entity.FarmTask;
import com.sergiogutierrez.digitalfarmer.service.FarmTaskService;

@RestController
@RequestMapping("/api/farmTasks")
public class FarmTaskController {

	private FarmTaskService farmTaskService;

	@Autowired
	public FarmTaskController(FarmTaskService farmTaskService) {
		this.farmTaskService = farmTaskService;
	}

	@GetMapping("/")
	public List<FarmTask> getAll() {
		return farmTaskService.getAll();
	}

	@GetMapping("/{farmTaskId}")
	public FarmTask getById(@PathVariable int farmTaskId) {
		FarmTask farmTask = farmTaskService.getById(farmTaskId);

		if (farmTask == null) {
			throw new RuntimeException("FarmTask id not found - " + farmTaskId);
		}

		return farmTask;
	}

	@PostMapping("/")
	public FarmTask add(@RequestBody FarmTask farmTask) {
		// Force a save in case an id is passed
		farmTask.setId(0);

		farmTaskService.save(farmTask);

		return farmTask;
	}

	@PutMapping("/")
	public FarmTask update(@RequestBody FarmTask farmTask) {
		farmTaskService.save(farmTask);

		return farmTask;
	}

	@DeleteMapping("/{farmTaskId}")
	public int delete(@PathVariable int farmTaskId) {

		FarmTask farmTask = farmTaskService.getById(farmTaskId);

		if (farmTask == null) {
			throw new RuntimeException("FarmTask id not found - " + farmTaskId);
		}

		farmTaskService.delete(farmTaskId);

		return farmTaskId;
	}

}
