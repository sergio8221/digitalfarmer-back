package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.CropEventDAO;
import com.sergiogutierrez.digitalfarmer.dao.SeasonDAO;
import com.sergiogutierrez.digitalfarmer.entity.CropEvent;
import com.sergiogutierrez.digitalfarmer.entity.Season;

@Service
public class CropEventServiceImpl implements CropEventService {

	private CropEventDAO DAO;

	@Autowired
	public CropEventServiceImpl(CropEventDAO DAO) {
		this.DAO = DAO;
	}

	@Autowired
	private SeasonDAO seasonDAO;

	@Override
	public List<CropEvent> getAll() {
		return DAO.getAll();
	}

	@Override
	public CropEvent getById(int id) {
		return DAO.getById(id);
	}

	@Override
	public List<CropEvent> getBySeasonId(int id) {
		Season season = seasonDAO.getById(id);

		return season.getCropEvents();
	}

	@Override
	public void save(CropEvent cropEvent) {
		DAO.save(cropEvent);

	}

	@Override
	@Transactional
	public void update(CropEvent cropEvent) {
		CropEvent ceToUpdate = DAO.getById(cropEvent.getId());

		ceToUpdate.setDescription(cropEvent.getDescription());
		ceToUpdate.setDate(cropEvent.getDate());
		ceToUpdate.setMoneyEarned(cropEvent.getMoneyEarned());
		ceToUpdate.setMoneySpent(cropEvent.getMoneySpent());

		DAO.save(ceToUpdate);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
