package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.FieldDAO;
import com.sergiogutierrez.digitalfarmer.entity.Field;

@Service
public class FieldServiceImpl implements FieldService {

	private FieldDAO DAO;

	@Autowired
	public FieldServiceImpl(FieldDAO DAO) {
		this.DAO = DAO;
	}

	@Override
	@Transactional
	public List<Field> getAll() {
		return DAO.getAll();
	}

	@Override
	@Transactional
	public Field getById(int id) {
		return DAO.getById(id);
	}

	@Override
	@Transactional
	public void save(Field field) {
		DAO.save(field);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
