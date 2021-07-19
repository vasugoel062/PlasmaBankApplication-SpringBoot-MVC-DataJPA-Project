package com.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Hospital;
import com.bean.Hospital_PlasmaStorage;
import com.model.service.Hospital_PlasmaStorageService;

@Controller
public class Hospital_PlasmaStorageController {
	@Autowired
	private Hospital_PlasmaStorageService hospital_PlasmaStorageService;

	@RequestMapping("/inputHospital_PlasmaStorageDetails")
	public ModelAndView registerHospital_PlasmaStorage(@RequestParam("operation") String operation,
			@ModelAttribute("hospital_Plasma") Hospital_PlasmaStorage hospital_PlasmaStorage, HttpSession session) {
		Hospital h = (Hospital) session.getAttribute("insertedHospitalWithId");
		hospital_PlasmaStorage.setHospital(h);
		List<Hospital_PlasmaStorage> plasmaList = (ArrayList<Hospital_PlasmaStorage>) session.getAttribute("listOfPlasma");
		if (plasmaList == null)
			plasmaList = new ArrayList<Hospital_PlasmaStorage>();
		switch (operation) {
		case "Add More":
			plasmaList.add(hospital_PlasmaStorage);
			session.setAttribute("listOfPlasma", plasmaList);
			return new ModelAndView("inputHospital_PlasmaStorageDetails", "hospital_Plasma",
					new Hospital_PlasmaStorage());

		case "Save":
			plasmaList.add(hospital_PlasmaStorage);
			if (plasmaList.size() != 0) {
				for (Hospital_PlasmaStorage hps : plasmaList) {
					if (hps.getUnits() != 0)
						hospital_PlasmaStorageService.registerBloodGroupDetails(hps);
				}
			}
			break;
		}

		return new ModelAndView("output", "message", "Hospital Registration Successful!");

	}
}
