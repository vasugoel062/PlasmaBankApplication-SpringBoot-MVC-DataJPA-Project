package com.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Donor;
import com.model.service.DonorService;

@Controller
public class DonorController {
	@Autowired
	private DonorService donorService;

	@RequestMapping("/inputDonorDetails")
	public ModelAndView registerDonorPageController() {
		return new ModelAndView("inputDonorDetails", "command", new Donor());
	}

	@RequestMapping("/donorRegister")
	public ModelAndView insertDonorController(Donor donor, HttpSession session) {
		if (donorService.registerDonor(donor)) {
			session.setAttribute("insertedDonor", donor);
			return new ModelAndView("checkExistingSeekers");
		}
		return new ModelAndView("output", "message", "Donor Registration Failed!");

	}

	@RequestMapping("/viewAllDonors")
	public ModelAndView viewAllDonorsController() {
		List<Donor> allDonors = donorService.getAllDonors();
		if (allDonors.size() > 0) {
			return new ModelAndView("displayDonors", "DonorsList", allDonors);
		}
		return new ModelAndView("output", "message", "We are Sorry!!! Currently No Donors are Available");
	}

}
