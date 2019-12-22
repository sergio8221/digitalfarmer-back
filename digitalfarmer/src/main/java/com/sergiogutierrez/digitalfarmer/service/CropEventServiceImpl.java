package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.CropEventDAO;
import com.sergiogutierrez.digitalfarmer.entity.CropEvent;

@Service
public class CropEventServiceImpl implements CropEventService {

	private CropEventDAO DAO;

	@Autowired
	public CropEventServiceImpl(CropEventDAO DAO) {
		this.DAO = DAO;
	}

	@Override
	@Transactional
	public List<CropEvent> getAll() {
		return DAO.getAll();
	}

	@Override
	@Transactional
	public CropEvent getById(int id) {
		return DAO.getById(id);
	}

	@Override
	@Transactional
	public void save(CropEvent cropEvent) {
		DAO.save(cropEvent);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
