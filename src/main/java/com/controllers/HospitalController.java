package com.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Donor;
import com.bean.Hospital;
import com.bean.Hospital_PlasmaStorage;
import com.model.service.HospitalService;
import com.model.service.Hospital_PlasmaStorageService;

@Controller
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;

	@RequestMapping("/inputHospitalDetails")
	public ModelAndView registerHospitalPageController() {
		return new ModelAndView("inputHospitalDetails", "command", new Hospital());
	}

	@RequestMapping("/hospitalRegister")
	public ModelAndView insertHospitalController(@ModelAttribute Hospital hospital, HttpSession session) {
		Hospital insertHospital = hospitalService.registerHospital(hospital);
		if (insertHospital != null) {
			Hospital insertedHospitalWithId = hospitalService.getLastInsertedHospitalWithId();
			session.setAttribute("insertedHospitalWithId", insertedHospitalWithId);
			return new ModelAndView("inputHospital_PlasmaStorageDetails", "hospital_Plasma",new Hospital_PlasmaStorage());
		}
		return new ModelAndView("output", "message", "Hospital Registration Failed!");

	}

	@RequestMapping("/viewAllHospitals")
	public ModelAndView viewHospitalsController(HttpSession session) {
		List<Hospital> allHospitals = hospitalService.getAllHospitals();
		if (allHospitals.size() > 0) {
			session.setAttribute("HospitalList", allHospitals);
			return new ModelAndView("displayHospitals", "HospitalsList", allHospitals);
		}
		return new ModelAndView("output", "message", "We are Sorry!!! Currently No Hospital are Available");
	}

	@RequestMapping("/viewPlasmaDetails")
	public ModelAndView viewHospitalPlasmaDetailsController(HttpSession session, @RequestParam("Id") String id) {
		List<Hospital> hList = (ArrayList<Hospital>) session.getAttribute("HospitalList");
		hList = hList.stream().filter(h -> h.getHospitalID() == Integer.parseInt(id)).collect(Collectors.toList());
		return new ModelAndView("viewPlasmaDetails", "viewHospitalPlasma", hList.get(0).gethPlasmaList());
	}
}
