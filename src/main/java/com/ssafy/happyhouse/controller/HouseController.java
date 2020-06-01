package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.service.HouseService;

@RequestMapping("/house")
@Controller
public class HouseController {
	
//	@Autowired
	private HouseService houseService;
	
	
	@GetMapping("/main.do")
	public String showMainView(String group) {
		return "house/dealList";
	}
	
	@GetMapping("/search.do")
	public String searchDeals() {
		return "house/dealList";
	}
	
	@GetMapping("/detail.do")
	public String showHouseInfo() {
		return "";
	}
}
