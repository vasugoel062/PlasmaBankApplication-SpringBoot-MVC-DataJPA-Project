package com.model.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bean.Hospital;
import com.bean.Seeker;
@Entity
public interface SeekerDao extends JpaRepository<Seeker,Integer>{
	

	List<Seeker> findByStateAndCityAndBloodGroup(String state, String city, String bloodGroup);

    @Query(value = "delete from Seeker where datediff(curdate(),s_date)>7",nativeQuery = true)
	boolean deleteAfter7days();
}
