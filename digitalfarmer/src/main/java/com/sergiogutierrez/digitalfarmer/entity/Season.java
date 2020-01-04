package com.sergiogutierrez.digitalfarmer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_field")
	private Field field;

	@OneToMany(mappedBy = "season", cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	private List<CropEvent> cropEvents;

	public Season() {
		// Empty constructor
	}

	public Season(int id, String crop, int year, String description, Field field, List<CropEvent> cropEvents) {
		super();
		this.id = id;
		this.crop = crop;
		this.year = year;
		this.description = description;
		this.field = field;
		this.cropEvents = cropEvents;
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

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public List<CropEvent> getCropEvents() {
		return cropEvents;
	}

	public void setCropEvents(List<CropEvent> cropEvents) {
		this.cropEvents = cropEvents;
	}

	@Override
	public String toString() {
		return "Season [id=" + id + ", crop=" + crop + ", year=" + year + ", description=" + description + ", field="
				+ field + ", cropEvents=" + cropEvents + "]";
	}

}
