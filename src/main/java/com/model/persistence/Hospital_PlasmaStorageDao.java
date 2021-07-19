package com.model.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Donor;
import com.bean.Hospital_PlasmaStorage;
@Repository
public interface Hospital_PlasmaStorageDao extends JpaRepository<Hospital_PlasmaStorage, Integer> {
	
		@Query("from Hospital_PlasmaStorage where hospitalID=:id")
		public List<Hospital_PlasmaStorage> findAllByHospitalId(@Param("id")int id);
}
