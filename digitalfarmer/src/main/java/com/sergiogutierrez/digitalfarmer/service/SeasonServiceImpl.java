package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.FieldDAO;
import com.sergiogutierrez.digitalfarmer.dao.SeasonDAO;
import com.sergiogutierrez.digitalfarmer.entity.Field;
import com.sergiogutierrez.digitalfarmer.entity.Season;

@Service
public class SeasonServiceImpl implements SeasonService {

	private SeasonDAO DAO;

	@Autowired
	public SeasonServiceImpl(SeasonDAO DAO) {
		this.DAO = DAO;
	}

	@Autowired
	private FieldDAO fieldDAO;

	@Override
	public List<Season> getAll() {
		return DAO.getAll();
	}

	@Override
	public Season getById(int id) {
		return DAO.getById(id);
	}

	@Override
	public List<Season> getByFieldId(int id) {
		Field field = fieldDAO.getById(id);

		return field.getSeasons();
	}

	@Override
	public void save(Season season) {
		DAO.save(season);

	}

	@Override
	@Transactional
	public void update(Season season) {
		Season seasonToUpdate = DAO.getById(season.getId());

		seasonToUpdate.setYear(season.getYear());
		seasonToUpdate.setCrop(season.getCrop());
		seasonToUpdate.setDescription(season.getDescription());

		DAO.save(seasonToUpdate);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
