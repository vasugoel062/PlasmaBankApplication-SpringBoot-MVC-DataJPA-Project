package com.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Donor;
import com.bean.Hospital;
import com.bean.Seeker;
import com.model.service.DonorService;
import com.model.service.HospitalService;
import com.model.service.SeekerService;

@Controller
@SessionAttributes({ "insertedSeekerDetails" })
public class SeekerController {
	@Autowired
	private SeekerService seekerService;
	@Autowired
	private DonorService donorService;
	@Autowired
	private HospitalService hospitalService;

	@RequestMapping("/inputSeekerDetails")
	public ModelAndView registerSeekerPageController() {
		return new ModelAndView("inputSeekerDetails", "command", new Seeker());
	}

	@RequestMapping("/seekerRegister")
	public ModelAndView insertSeekerController(@ModelAttribute Seeker seeker, HttpSession session) {
		session.setAttribute("insertedSeekerDetails", seeker);
		return new ModelAndView("redirect:/selectMatchingDetailsOption");
	}
//	
//	@RequestMapping("/seekerRegister")
//	public String insertSeekerController(@ModelAttribute Seeker seeker) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("insertedSeekerDetails", seeker);
//		return "redirect:/selectMatchingDetailsOption";
//	}

	@RequestMapping("/checkExistingSeekers")
	public ModelAndView checkExistingSeekersController(HttpSession session) {
		Donor donor = (Donor) session.getAttribute("insertedDonor");
		List<Seeker> seekersList;
			seekersList = seekerService.checkExistingSeeker(donor.getState(), donor.getCity(),donor.getBloodgroup());
			if (seekersList.size() > 0) {
				return new ModelAndView("displaySeekers", "seekersList", seekersList);
			}

		return new ModelAndView("output", "message", "Currently No Seeker is Required at Your Location");
	}

	static int count = 0;

	@RequestMapping("/selectMatchingDetailsOption")
	public ModelAndView getSeekerMatchingChoiceInputController(HttpSession session) {
		if (count == 2) {
			count = 0;
			Seeker seeker = (Seeker) session.getAttribute("insertedSeekerDetails");
			try {
				if (seekerService.registerSeeker(seeker))
					return new ModelAndView("output", "message", "We have Registered your Details!!! ");
			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("seekerInputForMatchingDetails");
	}

	@RequestMapping("/searchMatchingDetails")
	public ModelAndView searchMatchingDetailsController(@RequestParam("options") String options, HttpSession session) {
		Seeker seeker = (Seeker) session.getAttribute("insertedSeekerDetails");
		System.out.println(options);
		switch (options) {
		case "donor":
			Collection<Donor> matchingDonors = new ArrayList<>();
				matchingDonors = donorService.getAvailableDonors(seeker.getState(), seeker.getCity(), seeker.getBloodGroup());
				if (matchingDonors.size() > 0) {
					return new ModelAndView("displayDonors", "DonorsList", matchingDonors);
				} else {
					if (count != 2 && count < 2) {
						++count;
						return new ModelAndView("matchingDetailsNotFound", "message",
								"We are sorry , currently no Donor is Available at your Location");
					}
				}

		case "hospital":
			List<Hospital> matchingHospitals = new ArrayList<>();
				matchingHospitals = hospitalService.getAvailableHospitals(seeker.getState(), seeker.getCity(),
						seeker.getBloodGroup());
				if (matchingHospitals.size() > 0) {
					return new ModelAndView("displayHospitals", "HospitalsList", matchingHospitals);
				} else {
					if (count != 2 && count < 2) {
						++count;
						return new ModelAndView("matchingDetailsNotFound", "message",
								"We are sorry , currently no Hospital is Available at your Location");
					}
				}
		}
		return new ModelAndView("output", "message", "Invalid Choice");
	}

	@RequestMapping("/viewAllSeekers")
	public ModelAndView viewAllSeekersControllers() {
			List<Seeker> allSeekers = seekerService.getallSeekers();
			if (allSeekers.size() > 0) {
				if (!seekerService.removeSeekersAfter7Days()) {
					return new ModelAndView("displaySeekers", "seekersList", allSeekers);
				} else {
					return new ModelAndView("output", "message", "Error!!!Please Try Again");
				}
			}
		return new ModelAndView("output", "message", "We are Sorry!!! Currently No Seekers are Available");
	}
}
