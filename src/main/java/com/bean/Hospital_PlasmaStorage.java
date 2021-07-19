package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hospital_plasmabank")
public class Hospital_PlasmaStorage {
	@ManyToOne
	@JoinColumn(name = "hospitalID")
	private Hospital hospital;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital_plasmabank_seq")
	@SequenceGenerator(name = "hospital_plasmabank_seq", sequenceName = "hospital_plasmabank_seq", initialValue = 1, allocationSize = 1)
	private int plasma_Id;
	private String bloodGroup;
	private int units;
	public Hospital_PlasmaStorage(Hospital h, String bg, int n) {
		this.hospital = h;
		this.bloodGroup = bg;
		this.units = n;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public int getPlasma_Id() {
		return plasma_Id;
	}

	public void setPlasma_Id(int plasma_Id) {
		this.plasma_Id = plasma_Id;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
}
