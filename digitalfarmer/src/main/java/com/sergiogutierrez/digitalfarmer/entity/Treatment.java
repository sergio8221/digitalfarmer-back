package com.sergiogutierrez.digitalfarmer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "treatments")
public class Treatment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_treatment")
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "id_animal")
	private int idAnimal;

	public Treatment() {
		// Empty constructor
	}

	public Treatment(int id, String description, int idAnimal) {
		super();
		this.id = id;
		this.description = description;
		this.idAnimal = idAnimal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	@Override
	public String toString() {
		return "Treatment [id=" + id + ", description=" + description + ", idAnimal=" + idAnimal + "]";
	}

}
