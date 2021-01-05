package com.project.samsam.sujin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.samsam.sujin.api.AnimalApiUtil;
import com.project.samsam.sujin.api.AnimalInfo;
import com.project.samsam.sujin.api.Sido;
import com.project.samsam.sujin.api.Sigungu;

@Controller
@RequestMapping("/sujin")
public class ShelterController {

	@RequestMapping(value = "/pet_list", method = RequestMethod.GET)
	public String petList(Model model) throws Exception {

		AnimalApiUtil animalUtil = new AnimalApiUtil();

		ArrayList<Sido> sido = animalUtil.getSido();

		model.addAttribute("sido", sido);
		
		//
		ArrayList<AnimalInfo> animalList = animalUtil.getAnimalInfo(20140601, 20140601, 417000, "notice", 1, 10, "Y");
		
		model.addAttribute("animalList", animalList);
		

		return "/sujin/pet_list";
	}

	@RequestMapping(value = "/shelter_list", method = RequestMethod.GET)
	public String shelterList() {

		return "/sujin/shelter_list";
	}
	
	// 시군구 요청
	@RequestMapping(value = "/SiGunGu", method = RequestMethod.POST)
	public List<Sigungu> getSiGunGuList(Model model, int sidoCode) throws Exception{
		
		AnimalApiUtil animalUtil = new AnimalApiUtil();
		
		
		List<Sigungu> siGunGuList = animalUtil.getSiGunGu(sidoCode);
		model.addAttribute("sigungu", siGunGuList);
		
		return siGunGuList;
	}
	
	// 축종 요청
	
	
	
	

	
	// 동물 정보 요청
	
	
	
	
}
