package com.model.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Donor;

@Repository
public interface DonorDao extends JpaRepository<Donor, Integer> {
	
	List<Donor> findByStateAndCityAndBloodgroup(String state, String city,String bloodgroup);
}
