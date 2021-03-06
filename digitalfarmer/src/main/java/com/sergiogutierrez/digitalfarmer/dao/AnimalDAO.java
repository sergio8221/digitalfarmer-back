package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Animal;

public interface AnimalDAO {

	public List<Animal> getAll();

	public Animal getById(int id);

	public void save(Animal animal);

	public void delete(int id);

}
