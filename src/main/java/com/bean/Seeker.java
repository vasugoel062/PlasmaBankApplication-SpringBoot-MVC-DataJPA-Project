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
@Table(name = "seeker")
public class Seeker {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seeker_seq")
	@SequenceGenerator(name = "seeker_seq", sequenceName = "seeker_seq", initialValue = 1, allocationSize = 1)
	private int seekerId;
	private String seekerName;
	private String bloodGroup;
	private String contactNo;
	private int quantity;
	private String seekingDate;
	private String state;
	private String city;
}
