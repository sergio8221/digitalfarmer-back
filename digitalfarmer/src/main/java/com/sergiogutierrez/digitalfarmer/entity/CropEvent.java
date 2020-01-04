package com.sergiogutierrez.digitalfarmer.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_season")
	private Season season;

	public CropEvent() {
		// Empty constructor
	}

	public CropEvent(int id, Date date, String description, float moneySpent, float moneyEarned, Season season) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.moneySpent = moneySpent;
		this.moneyEarned = moneyEarned;
		this.season = season;
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

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "CropEvent [id=" + id + ", date=" + date + ", description=" + description + ", moneySpent=" + moneySpent
				+ ", moneyEarned=" + moneyEarned + ", season=" + season + "]";
	}

}
