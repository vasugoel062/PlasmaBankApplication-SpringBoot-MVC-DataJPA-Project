package com.model.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Hospital;
import com.bean.Hospital_PlasmaStorage;

@Repository
public interface HospitalDao extends JpaRepository<Hospital, Integer> {

	@Query(value = "select * from hospital where hospitalID = (select max(hospitalID) from hospital)", nativeQuery = true)
	public Hospital getLastInsertedRecord();

	@Query(value = "select * from hospital h , hospital_plasmabank hp where h.hospitalID=hp.hospitalID and lower(h.hLocation)=:state "
			+ "and lower(h.hCity)=:city and lower(hp.bloodGroup)=:bloodGroup ", nativeQuery = true)
	public List<Hospital> findByStateAndCityAndBloodgroup(@Param("state") String state, @Param("city") String city,
			@Param("bloodGroup") String bloodGroup);
}