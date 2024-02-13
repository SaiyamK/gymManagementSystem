package com.gym.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="userName")
	private String name;

	@Column(name="userEmail")
	private String email;

	@Column(name = "userPhoneNo")
	private String phoneNo;

	@ManyToOne
	@JoinColumn(name = "trainerID")
	private Trainer trainer;

	@ManyToOne
	@JoinColumn(name = "packageID")
	private Packages packages;

	@ManyToOne
	@JoinColumn(name = "gymID")
	private GymAdmin gymAdmin;

	public Users() {}

	public Users(Long id, String name, String email, String phoneNo, Trainer trainer, Packages packages,
			GymAdmin gymAdmin) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.trainer = trainer;
		this.packages = packages;
		this.gymAdmin = gymAdmin;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Trainer getTrainer() {
		return trainer;
	}


	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}


	public Packages getPackages() {
		return packages;
	}


	public void setPackages(Packages packages) {
		this.packages = packages;
	}




	public GymAdmin getGymAdmin() {
		return gymAdmin;
	}




	public void setGymAdmin(GymAdmin gymAdmin) {
		this.gymAdmin = gymAdmin;
	}




	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", trainer="
				+ trainer + ", packages=" + packages + ", gymAdmin=" + gymAdmin + "]";
	}







}
