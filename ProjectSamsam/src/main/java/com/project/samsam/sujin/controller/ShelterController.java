package com.project.samsam.sujin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.samsam.sujin.api.AnimalApiUtil;
import com.project.samsam.sujin.api.AnimalInfo;
import com.project.samsam.sujin.api.AnimalKind;
import com.project.samsam.sujin.api.Sido;
import com.project.samsam.sujin.api.Sigungu;

@Controller
@RequestMapping("/sujin")
public class ShelterController {

	// 보호 동물 찾기 화면
	@RequestMapping(value = "/pet_list", method = RequestMethod.GET)
	public String petList(Model model) throws Exception {

		AnimalApiUtil animalUtil = new AnimalApiUtil();
		
		// 날짜
		Calendar calendar = Calendar.getInstance();
		String year = "yyyy";
		
		SimpleDateFormat yyyy = new SimpleDateFormat(year);
		year = yyyy.format(calendar.getTime());
		
		// 연초~연말 (default)
		String firstDate = year + "0101";
		String lastDate = year + "1231";
		
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);
		System.out.println("@petList()");
		System.out.println(firstDate);
		System.out.println(lastDate);
		
		// 보호 동물 정보
		ArrayList<AnimalInfo> animalList = animalUtil.getAnimalInfo(firstDate, lastDate, 417000, "notice", 1, 10, "Y");
		model.addAttribute("animalList", animalList);
		
		// 시도
		ArrayList<Sido> sido = animalUtil.getSido();
		model.addAttribute("sido", sido);

		return "/sujin/pet_list";
	}
	
	
	// 보호소 찾기 화면
	@RequestMapping(value = "/shelter_list", method = RequestMethod.GET)
	public String shelterList(Model model) throws Exception {

		AnimalApiUtil animalUtil = new AnimalApiUtil();

		ArrayList<Sido> sido = animalUtil.getSido();

		model.addAttribute("sido", sido);
		//
		ArrayList<AnimalInfo> animalList = animalUtil.getAnimalInfo("20140601", "20140601", 417000, "notice", 1, 10, "Y");
		model.addAttribute("animalList", animalList);
		
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
	@RequestMapping(value = "/animalKind", method = RequestMethod.POST)
	public List<AnimalKind> getAnimalKindList(Model model, int upKindCode) throws Exception{
		
		AnimalApiUtil animalUtil = new AnimalApiUtil();
		
		List<AnimalKind> animalKindList = animalUtil.getAnimalKind(upKindCode);
		
		for (AnimalKind animalKind : animalKindList) {
			System.out.println(animalKind);
		}
		model.addAttribute("animalkind", animalKindList);
		
		return animalKindList;
	}
	
	
	// (필터)유기동물리스트  요청
	@RequestMapping(value = "/animalInfoList", method = RequestMethod.POST)
	public List<AnimalInfo> getAnimalList(Model model, String bgnde, String endde, Integer sido, Integer siGunGu, Integer upKind, Integer kind ) throws Exception{
		
		AnimalApiUtil animalUtil = new AnimalApiUtil();
		
		// '-' 제거하기
		bgnde = bgnde.replaceAll("-", "");
		endde = endde.replaceAll("-", "");
		
		// 보호 동물 정보
		ArrayList<AnimalInfo> animalList = animalUtil.getAnimalInfo(bgnde, endde, sido, siGunGu, upKind, kind, "notice", 1, 10, "Y");
		model.addAttribute("animalList", animalList);
		
		return animalList;
	}
	
	
	
	
	
	
	
	

	
}
