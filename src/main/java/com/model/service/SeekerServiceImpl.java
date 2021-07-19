package com.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bean.Seeker;
import com.model.persistence.SeekerDao;

@Service
public class SeekerServiceImpl implements SeekerService {
	
	@Autowired
	private SeekerDao seekerDao;

	@Override
	public boolean registerSeeker(Seeker seeker) {
		Seeker sekker = seekerDao.save(seeker);
		if (sekker != null)
			return true;
		return false;
	}

	@Override
	public List<Seeker> getallSeekers() {
		return seekerDao.findAll();
	}

	@Override
	public List<Seeker> checkExistingSeeker(String state, String city, String bloodGroup) {
		return seekerDao.findByStateAndCityAndBloodGroup(state, city, bloodGroup);
	}

	@Override
	public boolean removeSeekersAfter7Days() {
		return seekerDao.deleteAfter7days();
	}
}
