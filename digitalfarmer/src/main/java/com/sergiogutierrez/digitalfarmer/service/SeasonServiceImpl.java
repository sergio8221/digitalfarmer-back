package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.SeasonDAO;
import com.sergiogutierrez.digitalfarmer.entity.Season;

@Service
public class SeasonServiceImpl implements SeasonService {

	private SeasonDAO DAO;

	@Autowired
	public SeasonServiceImpl(SeasonDAO DAO) {
		this.DAO = DAO;
	}

	@Override
	@Transactional
	public List<Season> getAll() {
		return DAO.getAll();
	}

	@Override
	@Transactional
	public Season getById(int id) {
		return DAO.getById(id);
	}

	@Override
	public void save(Season season) {
		DAO.save(season);

	}

	@Override
	@Transactional
	public void delete(int id) {
		DAO.delete(id);

	}

}
