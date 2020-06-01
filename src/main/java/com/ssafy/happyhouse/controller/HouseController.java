package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.HousePageBean;
import com.ssafy.happyhouse.dto.TradeHub;
import com.ssafy.happyhouse.service.HouseService;
import com.ssafy.happyhouse.service.TradeHubService;
import com.ssafy.happyhouse.util.PageNavigation;

@RequestMapping("/house")
@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	@Autowired
	private TradeHubService tradeHubService;
	
	
	
	
	@GetMapping("/main")
	public String main(String group, int pg, String spp, Model model) {
		
		HousePageBean bean = new HousePageBean();
		
		int sizePerPage = spp == null ? 10 : Integer.parseInt(spp);//없으면 10개 보여주고 입력받은게 있으면 그만큼 보여줌
		
		switch(group) {
		case "all" :
			boolean[] allB = {true, true, true, true};
			bean.setSearchType(allB);
			break;
		case "apt" :
			boolean[] aptB = {true, true, false, false};
			bean.setSearchType(aptB);
			break;
		case "house" :
			boolean[] houseB = {false, false, true, true};
			bean.setSearchType(houseB);
			break;
		}
		
		try {
			List<HouseDeal> dealList =houseService.searchAll(pg, sizePerPage, bean);
			PageNavigation pageNavigation = houseService.makePageNavigation(pg, sizePerPage, bean);
			model.addAttribute("dealList", dealList);
			model.addAttribute("group", group);
			model.addAttribute("navigation", pageNavigation);

		} catch(Exception e) {
			model.addAttribute("msg", e.toString());
			return "/error.jsp";
		}
		
		return "house/dealList";
	}
	
	@GetMapping("/search")
	public String search(String category, String group, int pg, String spp, String search, Model model) {
		HousePageBean bean = new HousePageBean();
		
		int sizePerPage =spp == null?10:Integer.parseInt(spp);
		
		switch(group) {
		case "all" :
			boolean[] allB = {true, true, true, true};
			bean.setSearchType(allB);
			break;
		case "apt" :
			boolean[] aptB = {true, true, false, false};
			bean.setSearchType(aptB);
			break;
		case "house" :
			boolean[] houseB = {false, false, true, true};
			bean.setSearchType(houseB);
			break;
		}
		
		model.addAttribute("group", group);
		
		switch(category) {
			case "apt" :
				bean.setAptname(search);
				
				model.addAttribute("apt", category);
				model.addAttribute("search", search);
				break;
				
			case "dong" :
				bean.setDong(search);
				
				model.addAttribute("dong", category);
				model.addAttribute("search", search);
				break;
		}
		
		try {
			List<HouseDeal> dealList =houseService.searchAll(pg, sizePerPage, bean);
			PageNavigation pageNavigation = houseService.makePageNavigation(pg, sizePerPage, bean);
			model.addAttribute("dealList", dealList);
			model.addAttribute("navigation", pageNavigation);
			
		} catch(Exception e) {
			model.addAttribute("msg", "거래 정보 로드 실패");
			return "/error.jsp";
		}
		
		
		
		return "/house/dealList";
	}
	
	@GetMapping("/detail")
	public String showHouseInfo(int no, Model model) {
		
		HouseDeal deal = null;
		try {
			deal = houseService.search(no);
			model.addAttribute("deal", deal);
			
		} catch(Exception e) {
			model.addAttribute("msg", e.toString());
			return "/error.jsp";
		}
		
		try {

			List<TradeHub> shops = tradeHubService.findShopByDongName(deal.getDong().trim());

			model.addAttribute("shops", shops);
		} catch(Exception e) {
			model.addAttribute("msg", e.toString());
			return "/error.jsp";
		}
		return "/house/houseInfo";
	}
}
