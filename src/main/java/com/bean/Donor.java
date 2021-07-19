package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "donor")
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donor_seq")
	@SequenceGenerator(name = "donor_seq", sequenceName = "donor_seq", initialValue = 1, allocationSize = 1)
	private int donorId;
	private String name;
	private String bloodgroup;
	private int age;
	private String contactNo;
	private int units;
	private String city;
	private String state;

}
