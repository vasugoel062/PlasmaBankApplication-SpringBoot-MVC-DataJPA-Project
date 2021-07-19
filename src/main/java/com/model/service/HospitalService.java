package com.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Hospital;

public interface HospitalService {
	public Hospital registerHospital(Hospital hospital);

	public List<Hospital> getAllHospitals();

	public List<Hospital> getAvailableHospitals(String state, String city, String bloodGroup);
	
	public Hospital getLastInsertedHospitalWithId();
}
