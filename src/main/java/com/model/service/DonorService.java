package com.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bean.Donor;

public interface DonorService {
	
	boolean registerDonor(Donor donor);

	List<Donor> getAllDonors();

	List<Donor> getAvailableDonors(String state, String city, String bloodGroup);
}
