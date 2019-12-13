package com.sergiogutierrez.digitalfarmer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crop_events")
public class CropEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_event")
	private int id;

	@Column(name = "date")
	private Date date;

	@Column(name = "description")
	private String description;

	@Column(name = "money_spent")
	private float moneySpent;

	@Column(name = "money_earned")
	private float moneyEarned;

	@Column(name = "id_season")
	private int idSeason;

	public CropEvent() {
		// Empty constructor
	}

	public CropEvent(int id, Date date, String description, float moneySpent, float moneyEarned, int idSeason) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.moneySpent = moneySpent;
		this.moneyEarned = moneyEarned;
		this.idSeason = idSeason;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getMoneySpent() {
		return moneySpent;
	}

	public void setMoneySpent(float moneySpent) {
		this.moneySpent = moneySpent;
	}

	public float getMoneyEarned() {
		return moneyEarned;
	}

	public void setMoneyEarned(float moneyEarned) {
		this.moneyEarned = moneyEarned;
	}

	public int getIdSeason() {
		return idSeason;
	}

	public void setIdSeason(int idSeason) {
		this.idSeason = idSeason;
	}

	@Override
	public String toString() {
		return "CropEvent [id=" + id + ", date=" + date + ", description=" + description + ", moneySpent=" + moneySpent
				+ ", moneyEarned=" + moneyEarned + ", idSeason=" + idSeason + "]";
	}

}
