package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.bean.Hospital;
import com.bean.Hospital_PlasmaStorage;
import com.model.persistence.Hospital_PlasmaStorageDao;

@Service
public class Hospital_PlasmaStorageServiceImpl implements Hospital_PlasmaStorageService {
	
	@Autowired
	Hospital_PlasmaStorageDao hospital_PlasmaStorageDao;

	public boolean registerBloodGroupDetails(Hospital_PlasmaStorage hospital_PlasmaStorage) {
		Hospital_PlasmaStorage hp = hospital_PlasmaStorageDao.save(hospital_PlasmaStorage);
		if (hp != null) return true;
		return false;
	}
	

}
