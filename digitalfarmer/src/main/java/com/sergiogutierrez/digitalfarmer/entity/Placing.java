package com.sergiogutierrez.digitalfarmer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placings")
public class Placing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_placing")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "id_farm")
	private int idFarm;

	public Placing() {
		// Empty constructor
	}

	public Placing(int id, String name, int idFarm) {
		super();
		this.id = id;
		this.name = name;
		this.idFarm = idFarm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdFarm() {
		return idFarm;
	}

	public void setIdFarm(int idFarm) {
		this.idFarm = idFarm;
	}

	@Override
	public String toString() {
		return "Placing [id=" + id + ", name=" + name + ", idFarm=" + idFarm + "]";
	}

}
