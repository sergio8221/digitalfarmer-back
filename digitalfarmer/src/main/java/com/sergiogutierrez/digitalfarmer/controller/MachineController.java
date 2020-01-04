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

import com.sergiogutierrez.digitalfarmer.entity.Machine;
import com.sergiogutierrez.digitalfarmer.service.MachineService;

@RestController
@RequestMapping("/api/machines")
public class MachineController {

	private MachineService machineService;

	@Autowired
	public MachineController(MachineService machineService) {
		this.machineService = machineService;
	}

	@GetMapping("/")
	public List<Machine> getAll() {
		return machineService.getAll();
	}

	@GetMapping("/{machineId}")
	public Machine getById(@PathVariable int machineId) {
		Machine machine = machineService.getById(machineId);

		if (machine == null) {
			throw new RuntimeException("Machine id not found - " + machineId);
		}

		return machine;
	}
	
	@GetMapping("/farm/{farmId}")
	public List<Machine> getByFarmId(@PathVariable int farmId) {
		return machineService.getByFarmId(farmId);
	}

	@PostMapping("/")
	public Machine add(@RequestBody Machine machine) {
		// Force a save in case an id is passed
		machine.setId(0);

		machineService.save(machine);

		return machine;
	}

	@PutMapping("/")
	public Machine update(@RequestBody Machine machine) {
		machineService.update(machine);

		return machine;
	}

	@DeleteMapping("/{machineId}")
	public int delete(@PathVariable int machineId) {

		Machine machine = machineService.getById(machineId);

		if (machine == null) {
			throw new RuntimeException("Machine id not found - " + machineId);
		}

		machineService.delete(machineId);

		return machineId;
	}

}
