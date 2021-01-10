package com.project.samsam.sujin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.samsam.sujin.service.PayangService;

@Controller
@RequestMapping("/sujin/payang")
public class PayngController {

	@Autowired
	private PayangService service;
	
	// 파양 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception{
		model.addAttribute("list",service.list());
	}
	
	// 파양 글쓰기 화면
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerForm(Model model) throws Exception{
		
		
	}
	
}
