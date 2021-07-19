package com.example.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bean.Hospital;
import com.bean.Hospital_PlasmaStorage;
import com.model.persistence.HospitalDao;
import com.model.persistence.Hospital_PlasmaStorageDao;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.bean")
@EnableJpaRepositories(basePackages = "com.model.persistence")
public class PlasmaBankApplicationMvcDataJpaProjectApplication{
	@Autowired
	Hospital_PlasmaStorageDao hospital_PlasmaStorageDao;
	@Autowired
	HospitalDao hospitalDao;

	public static void main(String[] args) {
		SpringApplication.run(PlasmaBankApplicationMvcDataJpaProjectApplication.class, args);
	}
}
