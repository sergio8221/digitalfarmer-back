package com.sergiogutierrez.digitalfarmer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seasons")
public class Season {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_season")
	private int id;

	@Column(name = "crop")
	private String crop;

	@Column(name = "year")
	private int year;

	@Column(name = "description")
	private String description;

	@Column(name = "id_field")
	private int idField;

	public Season() {
		// Empty constructor
	}

	public Season(int id, String crop, int year, String description, int idField) {
		super();
		this.id = id;
		this.crop = crop;
		this.year = year;
		this.description = description;
		this.idField = idField;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdField() {
		return idField;
	}

	public void setIdField(int idField) {
		this.idField = idField;
	}

	@Override
	public String toString() {
		return "Season [id=" + id + ", crop=" + crop + ", year=" + year + ", description=" + description + ", idField="
				+ idField + "]";
	}

}
