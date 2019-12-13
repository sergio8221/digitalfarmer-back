package com.sergiogutierrez.digitalfarmer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maintenances")
public class Maintenance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_maintenance")
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "id_machine")
	private int idMachine;

	public Maintenance() {
		// Empty constructor
	}

	public Maintenance(int id, String description, int idMachine) {
		super();
		this.id = id;
		this.description = description;
		this.idMachine = idMachine;
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

	public int getIdMachine() {
		return idMachine;
	}

	public void setIdMachine(int idMachine) {
		this.idMachine = idMachine;
	}

	@Override
	public String toString() {
		return "Maintenance [id=" + id + ", description=" + description + ", idMachine=" + idMachine + "]";
	}

}
