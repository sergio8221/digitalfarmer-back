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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "animals")
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_animal")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "born")
	private Date born;

	@Column(name = "sex")
	private String sex;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_species")
	private Species species;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_placing")
	private Placing placing;

	@OneToMany(mappedBy = "animal", cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	private List<Treatment> treatments;

	public Animal() {
		// Empty constructor
	}

	public Animal(String name, String code, Date born, String sex) {
		this.name = name;
		this.code = code;
		this.born = born;
		this.sex = sex;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public Placing getPlacing() {
		return placing;
	}

	public void setPlacing(Placing placing) {
		this.placing = placing;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", code=" + code + ", born=" + born + ", sex=" + sex
				+ ", species=" + species + ", placing=" + placing + ", treatments=" + treatments + "]";
	}

}
