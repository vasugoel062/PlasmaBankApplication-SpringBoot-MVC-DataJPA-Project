package com.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Seeker;

public interface SeekerService {
	
	boolean registerSeeker(Seeker seeker) throws SQLException, ClassNotFoundException, IOException;

	List<Seeker> getallSeekers();

	List<Seeker> checkExistingSeeker(String state, String city, String bloodGroup);

	boolean removeSeekersAfter7Days();
}
