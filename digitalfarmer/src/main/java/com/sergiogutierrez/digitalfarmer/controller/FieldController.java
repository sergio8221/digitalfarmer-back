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

import com.sergiogutierrez.digitalfarmer.entity.Field;
import com.sergiogutierrez.digitalfarmer.service.FieldService;

@RestController
@RequestMapping("/api/fields")
public class FieldController {

	private FieldService fieldService;

	@Autowired
	public FieldController(FieldService fieldService) {
		this.fieldService = fieldService;
	}

	@GetMapping("/")
	public List<Field> getAll() {
		return fieldService.getAll();
	}

	@GetMapping("/{fieldId}")
	public Field getById(@PathVariable int fieldId) {
		Field field = fieldService.getById(fieldId);

		if (field == null) {
			throw new RuntimeException("Field id not found - " + fieldId);
		}

		return field;
	}

	@PostMapping("/")
	public Field add(@RequestBody Field field) {
		// Force a save in case an id is passed
		field.setId(0);

		fieldService.save(field);

		return field;
	}

	@PutMapping("/")
	public Field update(@RequestBody Field field) {
		fieldService.save(field);

		return field;
	}

	@DeleteMapping("/{fieldId}")
	public int delete(@PathVariable int fieldId) {

		Field field = fieldService.getById(fieldId);

		if (field == null) {
			throw new RuntimeException("Field id not found - " + fieldId);
		}

		fieldService.delete(fieldId);

		return fieldId;
	}

}
