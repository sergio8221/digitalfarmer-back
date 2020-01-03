package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Treatment;

public interface TreatmentService {

	public List<Treatment> getAll();

	public Treatment getById(int id);

	public List<Treatment> getByAnimalId(int id);

	public void save(Treatment treatment);
	
	public void update(Treatment treatment);

	public void delete(int id);

}
