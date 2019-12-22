package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.CropEvent;

public interface CropEventService {

	public List<CropEvent> getAll();

	public CropEvent getById(int id);

	public void save(CropEvent cropEvent);

	public void delete(int id);

}
