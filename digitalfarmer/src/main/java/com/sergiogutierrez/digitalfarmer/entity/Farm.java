package com.sergiogutierrez.digitalfarmer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farms")
public class Farm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_farm")
	private int id;

	@Column(name = "location")
	private String location;

	@Column(name = "id_user")
	private int idUser;

	public Farm() {
		// Empty constructor
	}

	public Farm(int id, String location, int idUser) {
		super();
		this.id = id;
		this.location = location;
		this.idUser = idUser;
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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Farm [id=" + id + ", location=" + location + ", idUser=" + idUser + "]";
	}

}
