package com.sergiogutierrez.digitalfarmer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farm_tasks")
public class FarmTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_task")
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "date")
	private Date date;

	@Column(name = "completed")
	private boolean completed;

	@Column(name = "id_farm")
	private int idFarm;

	public FarmTask() {
		// Empty constructor
	}

	public FarmTask(int id, String description, Date date, boolean completed, int idFarm) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.completed = completed;
		this.idFarm = idFarm;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int getIdFarm() {
		return idFarm;
	}

	public void setIdFarm(int idFarm) {
		this.idFarm = idFarm;
	}

	@Override
	public String toString() {
		return "FarmTask [id=" + id + ", description=" + description + ", date=" + date + ", completed=" + completed
				+ ", idFarm=" + idFarm + "]";
	}

}
