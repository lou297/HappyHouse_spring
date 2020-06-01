package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.service.TradeHubService;

@RequestMapping("/tradehub")
@Controller
public class TradeHubController {
	
	@Autowired
	private TradeHubService tradeHubService;
	
	@GetMapping("/category")
	public String findShopByCategory() {
		
		
		return "tradehub/tradeHubList";
	}
	
	@GetMapping("/dong")
	public String findShopByDongName() {
		
		return "tradehub/tradeHubList";
	}
}
