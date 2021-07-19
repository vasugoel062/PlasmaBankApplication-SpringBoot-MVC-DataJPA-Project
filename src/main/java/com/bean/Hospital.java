package com.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hospital")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="hospital_seq")
	@SequenceGenerator(name="hospital_seq",sequenceName="hospital_seq",initialValue = 1,allocationSize = 1)
	private int hospitalID;
	private String hName; 
	private String hType;
	private String hAddress;
	private String hLocation;
	private String hCity;
	private String hEmail;
	private String hContactno;
	@OneToMany(mappedBy = "hospital")
	//mapped By - > to stop making of third table
	private List<Hospital_PlasmaStorage> hPlasmaList;
	public Hospital(String hName, String hType, String hAddress, String hLocation, String hCity,
			String hEmail, String hContactno) {
		super();
		this.hName = hName;
		this.hType = hType;
		this.hAddress = hAddress;
		this.hLocation = hLocation;
		this.hCity = hCity;
		this.hEmail = hEmail;
		this.hContactno = hContactno;
	}
	public int getHospitalID() {
		return hospitalID;
	}
	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public String gethType() {
		return hType;
	}
	public void sethType(String hType) {
		this.hType = hType;
	}
	public String gethAddress() {
		return hAddress;
	}
	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}
	public String gethLocation() {
		return hLocation;
	}
	public void sethLocation(String hLocation) {
		this.hLocation = hLocation;
	}
	public String gethCity() {
		return hCity;
	}
	public void sethCity(String hCity) {
		this.hCity = hCity;
	}
	public String gethEmail() {
		return hEmail;
	}
	public void sethEmail(String hEmail) {
		this.hEmail = hEmail;
	}
	public String gethContactno() {
		return hContactno;
	}
	public void sethContactno(String hContactno) {
		this.hContactno = hContactno;
	}
	public List<Hospital_PlasmaStorage> gethPlasmaList() {
		return hPlasmaList;
	}
	public void sethPlasmaList(List<Hospital_PlasmaStorage> hPlasmaList) {
		this.hPlasmaList = hPlasmaList;
	}
}
