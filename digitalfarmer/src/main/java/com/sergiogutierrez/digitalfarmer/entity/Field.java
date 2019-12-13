package com.sergiogutierrez.digitalfarmer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fields")
public class Field {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_field")
	private int id;

	@Column(name = "location")
	private String location;

	@Column(name = "area")
	private float area;

	@Column(name = "description")
	private String description;

	@Column(name = "id_farm")
	private int idFarm;

	public Field() {
		// Empty constructor
	}

	public Field(int id, String location, float area, String description, int idFarm) {
		super();
		this.id = id;
		this.location = location;
		this.area = area;
		this.description = description;
		this.idFarm = idFarm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdFarm() {
		return idFarm;
	}

	public void setIdFarm(int idFarm) {
		this.idFarm = idFarm;
	}

	@Override
	public String toString() {
		return "Field [id=" + id + ", location=" + location + ", area=" + area + ", description=" + description
				+ ", idFarm=" + idFarm + "]";
	}

}
