package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Treatment;

public interface TreatmentDAO {

	public List<Treatment> getAll();

	public Treatment getById(int id);

	public void save(Treatment treatment);

	public void delete(int id);

}
