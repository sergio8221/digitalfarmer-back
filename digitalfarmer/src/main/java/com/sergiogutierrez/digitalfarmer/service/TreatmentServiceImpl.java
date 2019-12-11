package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.dao.TreatmentDAO;
import com.sergiogutierrez.digitalfarmer.entity.Treatment;

public class TreatmentServiceImpl implements TreatmentService {

	private TreatmentDAO treatmentDAO;

	public TreatmentServiceImpl(TreatmentDAO treatmentDAO) {
		this.treatmentDAO = treatmentDAO;
	}

	@Override
	public List<Treatment> getAll() {
		return treatmentDAO.getAll();
	}

	@Override
	public Treatment getById(int id) {
		return treatmentDAO.getById(id);
	}

	@Override
	public void save(Treatment treatment) {
		treatmentDAO.save(treatment);
	}

	@Override
	public void delete(int id) {
		treatmentDAO.delete(id);
	}

}
