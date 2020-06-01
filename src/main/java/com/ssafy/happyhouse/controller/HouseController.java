package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.service.HouseService;

@RequestMapping("/house")
@Controller
public class HouseController {
	
	private HouseService houseService;
	
	@Autowired
	public void setBookService(HouseService houseService) {
		this.houseService = houseService;
	}
	
	
	@GetMapping("/main")
	public String showMainView(String group) {
		return "house/dealList";
	}
	
	@GetMapping("/search")
	public String searchDeals() {
		return "house/dealList";
	}
	
	@GetMapping("/detail")
	public String showHouseInfo() {
		return "";
	}
}
