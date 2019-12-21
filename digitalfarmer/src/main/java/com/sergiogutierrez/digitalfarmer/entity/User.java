package com.sergiogutierrez.digitalfarmer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String code;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	private Farm farm;

	public User() {
		// Empty constructor
	}

	public User(int id, String email, String code, String name, Farm farm) {
		super();
		this.id = id;
		this.email = email;
		this.code = code;
		this.name = name;
		this.farm = farm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", code=" + code + ", name=" + name + ", farm=" + farm + "]";
	}

}
