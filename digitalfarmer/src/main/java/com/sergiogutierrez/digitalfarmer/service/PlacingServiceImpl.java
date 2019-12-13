package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sergiogutierrez.digitalfarmer.dao.PlacingDAO;
import com.sergiogutierrez.digitalfarmer.entity.Placing;

@Service
public class PlacingServiceImpl implements PlacingService {

	private PlacingDAO placingDAO;

	public PlacingServiceImpl(PlacingDAO placingDAO) {
		this.placingDAO = placingDAO;
	}

	@Override
	public List<Placing> getAll() {
		return placingDAO.getAll();
	}

	@Override
	public Placing getById(int id) {
		return placingDAO.getById(id);
	}

	@Override
	public void save(Placing placing) {
		placingDAO.save(placing);
	}

	@Override
	public void delete(int id) {
		placingDAO.delete(id);
	}

}
