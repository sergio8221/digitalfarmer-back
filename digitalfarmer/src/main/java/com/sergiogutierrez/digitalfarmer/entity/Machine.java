package com.sergiogutierrez.digitalfarmer.entity;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_farm")
	private Farm farm;

	@OneToMany(mappedBy = "machine", cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	private List<Maintenance> maintenances;

	public Machine() {
		// Empty constructor
	}

	public Machine(int id, String name, Date adquisition, float prize, Farm farm, List<Maintenance> maintenances) {
		super();
		this.id = id;
		this.name = name;
		this.adquisition = adquisition;
		this.prize = prize;
		this.farm = farm;
		this.maintenances = maintenances;
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

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	public List<Maintenance> getMaintenances() {
		return maintenances;
	}

	public void setMaintenances(List<Maintenance> maintenances) {
		this.maintenances = maintenances;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", name=" + name + ", adquisition=" + adquisition + ", prize=" + prize + ", farm="
				+ farm + ", maintenances=" + maintenances + "]";
	}

}
