package com.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bean.Donor;
import com.model.persistence.DonorDao;

@Service
public class DonorServiceImpl implements DonorService {
	
	@Autowired
	private DonorDao donorDao;

	@Override
	public boolean registerDonor(Donor donor) {
		Donor d = donorDao.save(donor);
		if (d != null) return true;
		return false;
	}

	@Override
	public List<Donor> getAllDonors() {
		return donorDao.findAll();
	}

	@Override
	public List<Donor> getAvailableDonors(String state, String city, String bloodgroup) {
		return donorDao.findByStateAndCityAndBloodgroup(state, city, bloodgroup);
	}

}
