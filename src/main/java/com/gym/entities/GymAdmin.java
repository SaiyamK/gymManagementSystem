package com.gym.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="gymAdmin")
public class GymAdmin {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long gymID;

	@Column(name="gymName")
	private String name;

	@Column(name="gymLocation")
	private String location;

	public GymAdmin() {}
	public GymAdmin(Long gymID, String name, String location) {
		this.gymID = gymID;
		this.name = name;
		this.location = location;
	}

	public Long getGymID() {
		return gymID;
	}

	public void setGymID(Long gymID) {
		this.gymID = gymID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "GymAdmin [gymID=" + gymID + ", name=" + name + ", location=" + location + "]";
	}
}
