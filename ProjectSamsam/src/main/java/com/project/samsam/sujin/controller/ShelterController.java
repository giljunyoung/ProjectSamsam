package com.project.samsam.sujin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.samsam.sujin.api.AnimalApiUtil;

@Controller
@RequestMapping("/sujin")
public class ShelterController {
	
	@RequestMapping(value = "/pet_list", method = RequestMethod.GET)
	public String petList(Model model) throws Exception {
		
		AnimalApiUtil animalUtil = new AnimalApiUtil();
		
		StringBuilder sb = animalUtil.getSido();
		
		model.addAttribute("sido", sb.toString());
		
		return "/sujin/pet_list"; 
	}
	
	
	@RequestMapping(value = "/shelter_list", method = RequestMethod.GET)
	public String shelterList() {
		
		return "/sujin/shelter_list"; 
	}
	
	@RequestMapping(value = "/abandonment_list", method = RequestMethod.GET)
	public String abandonmentList() {
		return "/sujin/abandonment_list";
	}
	
	

}
