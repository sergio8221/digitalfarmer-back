package com.sergiogutierrez.digitalfarmer.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "treatments")
public class Treatment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_treatment")
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "date_init")
	private Date dateInit;

	@Column(name = "date_end")
	private Date dateEnd;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_animal", foreignKey = @ForeignKey(name = "id_animal"))
	private Animal animal;

	public Treatment() {
		// Empty constructor
	}

	public Treatment(int id, String description, Date dateInit, Date dateEnd, Animal animal) {
		super();
		this.id = id;
		this.description = description;
		this.dateInit = dateInit;
		this.dateEnd = dateEnd;
		this.animal = animal;
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

	public Date getDateInit() {
		return dateInit;
	}

	public void setDateInit(Date dateInit) {
		this.dateInit = dateInit;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "Treatment [id=" + id + ", description=" + description + ", dateInit=" + dateInit + ", dateEnd="
				+ dateEnd + ", animal=" + animal + "]";
	}

}
