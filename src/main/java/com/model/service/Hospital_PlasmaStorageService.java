package com.model.service;

import java.io.IOException;
import java.sql.SQLException;

import com.bean.Hospital;
import com.bean.Hospital_PlasmaStorage;
import com.model.persistence.HospitalDao;

import java.util.*;

public interface Hospital_PlasmaStorageService {
	
	public boolean registerBloodGroupDetails(Hospital_PlasmaStorage hospital_PlasmaStorage);
}
