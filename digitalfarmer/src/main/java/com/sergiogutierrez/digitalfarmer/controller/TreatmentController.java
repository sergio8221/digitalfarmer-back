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

import com.sergiogutierrez.digitalfarmer.entity.Treatment;
import com.sergiogutierrez.digitalfarmer.service.TreatmentService;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {
	
	private TreatmentService treatmentService;

	@Autowired
	public TreatmentController(TreatmentService treatmentService) {
		this.treatmentService = treatmentService;
	}

	@GetMapping("/")
	public List<Treatment> getAll() {
		return treatmentService.getAll();
	}

	@GetMapping("/{treatmentId}")
	public Treatment getById(@PathVariable int treatmentId) {
		Treatment treatment = treatmentService.getById(treatmentId);

		if (treatment == null) {
			throw new RuntimeException("Treatment id not found - " + treatmentId);
		}

		return treatment;
	}

	@PostMapping("/")
	public Treatment add(@RequestBody Treatment treatment) {
		// Force a save in case an id is passed
		treatment.setId(0);

		treatmentService.save(treatment);

		return treatment;
	}

	@PutMapping("/")
	public Treatment update(@RequestBody Treatment treatment) {
		treatmentService.save(treatment);

		return treatment;
	}

	@DeleteMapping("/{treatmentId}")
	public int delete(@PathVariable int treatmentId) {

		Treatment treatment = treatmentService.getById(treatmentId);

		if (treatment == null) {
			throw new RuntimeException("Treatment id not found - " + treatmentId);
		}

		treatmentService.delete(treatmentId);

		return treatmentId;
	}

}
