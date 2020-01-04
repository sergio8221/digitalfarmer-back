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

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_farm")
	private Farm farm;

	@OneToMany(mappedBy = "field", cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	private List<Season> seasons;

	public Field() {
		// Empty constructor
	}

	public Field(int id, String location, float area, String description, Farm farm, List<Season> seasons) {
		super();
		this.id = id;
		this.location = location;
		this.area = area;
		this.description = description;
		this.farm = farm;
		this.seasons = seasons;
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

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

	@Override
	public String toString() {
		return "Field [id=" + id + ", location=" + location + ", area=" + area + ", description=" + description
				+ ", farm=" + farm + ", seasons=" + seasons + "]";
	}

}
