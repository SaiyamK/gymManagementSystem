package com.gym.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="packages")
public class Packages {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long packageID;

	@Column(name = "packageName")
	private String packageName;

	@Column(name = "packageFees")
	private int packageFees;

	@Column(name = "isMealIncluded")
	private boolean isMealIncluded;

	public Packages() {}

	public Packages(Long packageNo, String packageName, int packageFees, boolean isMealIncluded) {
		this.packageID = packageNo;
		this.packageName = packageName;
		this.packageFees = packageFees;
		this.isMealIncluded = isMealIncluded;
	}


	public Long getPackageNo() {
		return packageID;
	}
	public void setPackageNo(Long packageNo) {
		this.packageID = packageNo;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public int getPackageFees() {
		return packageFees;
	}
	public void setPackageFees(int packageFees) {
		this.packageFees = packageFees;
	}
	public boolean isMealIncluded() {
		return isMealIncluded;
	}
	public void setMealIncluded(boolean isMealIncluded) {
		this.isMealIncluded = isMealIncluded;
	}

	@Override
	public String toString() {
		return "Packages [packageNo=" + packageID + ", packageName=" + packageName + ", packageFees=" + packageFees
				+ ", isMealIncluded=" + isMealIncluded;
	}


}
