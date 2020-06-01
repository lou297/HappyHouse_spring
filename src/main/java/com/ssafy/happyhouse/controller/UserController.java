package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.service.HouseMemberService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private HouseMemberService houseMemberService;
	
	@GetMapping("/registPage")
	public String registerPage() {
		return "redirect:/WEB-INF/views/user/join.jsp";
	}
	
	@PostMapping("/register")
	public String register() {
		
		
		return "redirect:/index.jsp";
	}
	
	@GetMapping("/modifyPage")
	public String modifyPage() {
		
		return "/user/modify";
	}
	
	@PostMapping("/modify")
	public String modify() {
		return "/user/userInfo";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "redirect:/index.jsp";
	}
	
	@GetMapping("/find")
	public String find() {
		
		return "/user/userInfo";
	}
	
	@GetMapping("/loginPage")
	public String loginPage() {
		
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String login() {
		return "redirect:/index.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userinfo");
		return "redirect:/index.jsp";
	}
	
	@GetMapping("/findPwPage")
	public String findPwPage() {
		
		
		return "redirect:/WEB-INF/views/user/findPw.jsp";
	}
	
	@PostMapping("/findPw")
	public String findPw() {
		
		
		return "/user/findPw";
		
	}

}
