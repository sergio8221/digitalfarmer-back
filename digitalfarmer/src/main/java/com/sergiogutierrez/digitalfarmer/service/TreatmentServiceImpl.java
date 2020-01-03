package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergiogutierrez.digitalfarmer.dao.AnimalDAO;
import com.sergiogutierrez.digitalfarmer.dao.TreatmentDAO;
import com.sergiogutierrez.digitalfarmer.entity.Animal;
import com.sergiogutierrez.digitalfarmer.entity.Treatment;

@Service
public class TreatmentServiceImpl implements TreatmentService {

	private TreatmentDAO treatmentDAO;

	@Autowired
	private AnimalDAO animalDAO;

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
	public List<Treatment> getByAnimalId(int id) {
		Animal animal = animalDAO.getById(id);

		return animal.getTreatments();
	}

	@Override
	public void save(Treatment treatment) {
		treatmentDAO.save(treatment);
	}
	
	@Override
	@Transactional
	public void update(Treatment treatment) {
		Treatment treatmentToUpdate = treatmentDAO.getById(treatment.getId());
		
		treatmentToUpdate.setDescription(treatment.getDescription());
		treatmentToUpdate.setDateInit(treatment.getDateInit());
		treatmentToUpdate.setDateEnd(treatment.getDateEnd());
		
		treatmentDAO.save(treatmentToUpdate);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		treatmentDAO.delete(id);
	}

}
