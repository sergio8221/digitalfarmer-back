package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.FarmDAO;
import com.sergiogutierrez.digitalfarmer.dao.FieldDAO;
import com.sergiogutierrez.digitalfarmer.entity.Farm;
import com.sergiogutierrez.digitalfarmer.entity.Field;

@Service
public class FieldServiceImpl implements FieldService {

	private FieldDAO DAO;

	@Autowired
	public FieldServiceImpl(FieldDAO DAO) {
		this.DAO = DAO;
	}

	@Autowired
	private FarmDAO farmDAO;

	@Override
	public List<Field> getAll() {
		return DAO.getAll();
	}

	@Override
	public Field getById(int id) {
		return DAO.getById(id);
	}

	@Override
	public List<Field> getByFarmId(int id) {
		Farm farm = farmDAO.getById(id);

		return farm.getFields();
	}

	@Override
	public void save(Field field) {
		DAO.save(field);

	}

	@Override
	@Transactional
	public void update(Field field) {
		Field fieldToUpdate = DAO.getById(field.getId());

		fieldToUpdate.setLocation(field.getLocation());
		fieldToUpdate.setArea(field.getArea());
		fieldToUpdate.setDescription(field.getDescription());

		DAO.save(fieldToUpdate);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
