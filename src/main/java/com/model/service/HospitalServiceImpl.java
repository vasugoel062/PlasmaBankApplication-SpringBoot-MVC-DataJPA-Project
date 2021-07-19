package com.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bean.Hospital;
import com.bean.Hospital_PlasmaStorage;
import com.model.persistence.HospitalDao;
import com.model.persistence.Hospital_PlasmaStorageDao;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private Hospital_PlasmaStorageDao hospital_PlasmaStorageDao;

	public Hospital registerHospital(Hospital hospital) {
		Hospital h = hospitalDao.save(hospital);
		if (h != null) {
			Hospital hosp = hospitalDao.getLastInsertedRecord();
			return hosp;
		}
		return null;
	}

	public List<Hospital> getAllHospitals() {
		List<Hospital> hpList = hospitalDao.findAll();
		for (Hospital h : hpList) {
			List<Hospital_PlasmaStorage> list = hospital_PlasmaStorageDao.findAllByHospitalId(h.getHospitalID());
			h.sethPlasmaList(list);
		}
		return hpList;
	}

	public List<Hospital> getAvailableHospitals(String state, String city, String bloodGroup) {
		List<Hospital> matchingHpList = hospitalDao.findByStateAndCityAndBloodgroup(state, city, bloodGroup);
		for (Hospital h : matchingHpList) {
			h.sethPlasmaList(hospital_PlasmaStorageDao.findAllByHospitalId(h.getHospitalID()));
		}
		return matchingHpList;
	}

	@Override
	public Hospital getLastInsertedHospitalWithId() {
		return hospitalDao.getLastInsertedRecord();
	}
}
