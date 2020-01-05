package com.sergiogutierrez.digitalfarmer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "farms")
public class Farm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_farm")
	private int id;

	@Column(name = "location")
	private String location;

	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "id_user")
	private User user;

	@OneToMany(mappedBy = "farm", cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	private List<Placing> placings;

	@OneToMany(mappedBy = "farm", cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	private List<FarmTask> tasks;

	@OneToMany(mappedBy = "farm", cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	private List<Machine> machines;

	@OneToMany(mappedBy = "farm", cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	private List<Field> fields;

	public Farm() {
		// Empty constructor
	}

	public Farm(int id, String location) {
		this.id = id;
		this.location = location;
	}

	public Farm(int id, String location, User user, List<Placing> placings, List<FarmTask> tasks,
			List<Machine> machines, List<Field> fields) {
		super();
		this.id = id;
		this.location = location;
		this.user = user;
		this.placings = placings;
		this.tasks = tasks;
		this.machines = machines;
		this.fields = fields;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Placing> getPlacings() {
		return placings;
	}

	public void setPlacings(List<Placing> placings) {
		this.placings = placings;
	}

	public List<FarmTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<FarmTask> tasks) {
		this.tasks = tasks;
	}

	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "Farm [id=" + id + ", location=" + location + ", user=" + user + ", placings=" + placings + ", tasks="
				+ tasks + ", machines=" + machines + ", fields=" + fields + "]";
	}

}
