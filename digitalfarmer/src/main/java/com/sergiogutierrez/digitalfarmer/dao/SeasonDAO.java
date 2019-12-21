package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.Season;

public interface SeasonDAO {

	public List<Season> getAll();

	public Season getById(int id);

	public void save(Season season);

	public void delete(int id);

}
