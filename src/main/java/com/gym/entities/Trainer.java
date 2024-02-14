package com.gym.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="trainer")
public class Trainer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Trainer name cannot be Blank")
	@Column(name="trainerName")
	private String trainerName;

	@NotBlank(message = "Phone Number cannot be Blank")
	@Column(name="phoneNo")
	private String phoneNo;

	@NotBlank(message = "Specialization cannot be Blank")
	@Column(name="specialization")
	private String specialization;

	@ManyToOne
	@JoinColumn(name = "gymID")
	private GymAdmin gymAdmin;

	public Trainer() {}

	public Trainer(Long id, String trainerName, String phoneNo, String specialization, GymAdmin gymAdmin) {
		super();
		this.id = id;
		this.trainerName = trainerName;
		this.phoneNo = phoneNo;
		this.specialization = specialization;
		this.gymAdmin = gymAdmin;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public GymAdmin getGymAdmin() {
		return gymAdmin;
	}

	public void setGymAdmin(GymAdmin gymAdmin) {
		this.gymAdmin = gymAdmin;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", trainerName=" + trainerName + ", phoneNo=" + phoneNo + ", specialization="
				+ specialization + ", gymAdmin=" + gymAdmin + "]";
	}

}
