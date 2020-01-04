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

import com.sergiogutierrez.digitalfarmer.entity.Maintenance;
import com.sergiogutierrez.digitalfarmer.service.MaintenanceService;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {

	private MaintenanceService maintenanceService;

	@Autowired
	public MaintenanceController(MaintenanceService maintenanceService) {
		this.maintenanceService = maintenanceService;
	}

	@GetMapping("/")
	public List<Maintenance> getAll() {
		return maintenanceService.getAll();
	}

	@GetMapping("/{maintenanceId}")
	public Maintenance getById(@PathVariable int maintenanceId) {
		Maintenance maintenance = maintenanceService.getById(maintenanceId);

		if (maintenance == null) {
			throw new RuntimeException("Maintenance id not found - " + maintenanceId);
		}

		return maintenance;
	}

	@GetMapping("/machine/{machineID}")
	public List<Maintenance> getByFarmId(@PathVariable int machineID) {
		return maintenanceService.getByMachineId(machineID);
	}

	@PostMapping("/")
	public Maintenance add(@RequestBody Maintenance maintenance) {
		// Force a save in case an id is passed
		maintenance.setId(0);

		maintenanceService.save(maintenance);

		return maintenance;
	}

	@PutMapping("/")
	public Maintenance update(@RequestBody Maintenance maintenance) {
		maintenanceService.update(maintenance);

		return maintenance;
	}

	@DeleteMapping("/{maintenanceId}")
	public int delete(@PathVariable int maintenanceId) {

		Maintenance maintenance = maintenanceService.getById(maintenanceId);

		if (maintenance == null) {
			throw new RuntimeException("Maintenance id not found - " + maintenanceId);
		}

		maintenanceService.delete(maintenanceId);

		return maintenanceId;
	}

}
