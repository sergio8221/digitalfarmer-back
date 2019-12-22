package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Season;

public interface SeasonService {

	public List<Season> getAll();

	public Season getById(int id);

	public void save(Season season);

	public void delete(int id);

}
