package com.sergiogutierrez.digitalfarmer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "machinery")
public class Machine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_machine")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "adquisition")
	private Date adquisition;

	@Column(name = "prize")
	private float prize;

	@Column(name = "id_farm")
	private int idFarm;

	public Machine() {
		// Empty constructor
	}

	public Machine(int id, String name, Date adquisition, float prize, int idFarm) {
		super();
		this.id = id;
		this.name = name;
		this.adquisition = adquisition;
		this.prize = prize;
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

	public Date getAdquisition() {
		return adquisition;
	}

	public void setAdquisition(Date adquisition) {
		this.adquisition = adquisition;
	}

	public float getPrize() {
		return prize;
	}

	public void setPrize(float prize) {
		this.prize = prize;
	}

	public int getIdFarm() {
		return idFarm;
	}

	public void setIdFarm(int idFarm) {
		this.idFarm = idFarm;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", name=" + name + ", adquisition=" + adquisition + ", prize=" + prize
				+ ", idFarm=" + idFarm + "]";
	}

}
