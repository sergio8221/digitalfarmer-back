package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public void update(Placing placing) {
		Placing placingToUpdate = placingDAO.getById(placing.getId());
		
		placingToUpdate.setName(placing.getName());
		
		placingDAO.save(placingToUpdate);
	}

	@Override
	@Transactional
	public void delete(int id) {
		placingDAO.delete(id);
	}

}
