package com.sergiogutierrez.digitalfarmer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "id_species")
	private int idSpecies;

	@Column(name = "id_placing")
	private int idPlacing;

	public Animal() {
		// Empty constructor
	}

	public Animal(String name, String code, Date born, String sex, int idSpecies, int idPlacing) {
		this.name = name;
		this.code = code;
		this.born = born;
		this.sex = sex;
		this.idSpecies = idSpecies;
		this.idPlacing = idPlacing;
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

	public int getIdSpecies() {
		return idSpecies;
	}

	public void setIdSpecies(int idSpecies) {
		this.idSpecies = idSpecies;
	}

	public int getIdPlacing() {
		return idPlacing;
	}

	public void setIdPlacing(int idPlacing) {
		this.idPlacing = idPlacing;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", code=" + code + ", born=" + born + ", sex=" + sex
				+ ", idSpecies=" + idSpecies + ", idPlacing=" + idPlacing + "]";
	}

}
