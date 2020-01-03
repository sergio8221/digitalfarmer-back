package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Animal;

public interface AnimalService {

	public List<Animal> getAll();

	public Animal getById(int id);

	public void save(Animal animal);
	
	public void update(Animal animal);

	public void delete(int id);

}
