package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.dto.HouseMember;
import com.ssafy.happyhouse.service.HouseMemberService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private HouseMemberService houseMemberService;
	
	@GetMapping("/registPage")
	public String registerPage() {
		return "/user/join";
	}
	
	@PostMapping("/register")
	public String register(HouseMember houseMember, Model model) {
		
		try {
			HouseMember hm = houseMemberService.insert(houseMember.getId(), houseMember.getPassword(), houseMember.getName(), houseMember.getAddress(), houseMember.getPhone());
			
			System.out.println("hm : " + hm.getName());
		} catch (Exception e) {
			model.addAttribute("msg", "회원 가입 중 문제가 발생했습니다.");
			return "redirect:/error.jsp";
		}
		
		return "redirect:/index.jsp";
	}
	
	@GetMapping("/modifyPage")
	public String modifyPage(HttpSession session, Model model) {
		
		HouseMember housemember = (HouseMember) session.getAttribute("userinfo");
		model.addAttribute("user", housemember);
		return "/user/modify";
	}
	
	@PostMapping("/modify")
	public String modify(HouseMember houseMember, HttpSession session) {
		
		int n = houseMemberService.update(houseMember.getId(), houseMember.getPassword(), houseMember.getName(), houseMember.getAddress(), houseMember.getPhone());
		
		if(n > 0) {
			session.setAttribute("userinfo", houseMember);
		}
		
		return "/user/userInfo";
	}
	
	@GetMapping("/delete")
	public String delete(HttpSession session) {
		
		HouseMember housemember = (HouseMember) session.getAttribute("userinfo");
		houseMemberService.delete(housemember.getId());
		session.removeAttribute("userinfo");
		
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
	public String login(String id, String password, HttpSession session, Model model) {
		System.out.println("id, pw : " + id +", " +password );
		try {
			HouseMember houseMember = houseMemberService.login(id, password);
			if (houseMember != null) {
				session.setAttribute("userinfo", houseMember);
				session.setMaxInactiveInterval(60 * 60);
			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호를 확인해주세요.");
				return "redirect:/error.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생핬습니다.");
			return "redirect:/error.jsp";
		}
		
		return "redirect:/index.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userinfo");
		return "redirect:/index.jsp";
	}
	
	@GetMapping("/findPwPage")
	public String findPwPage() {
		
		
		return "/user/findPw";
	}
	
	@PostMapping("/findPw")
	public String findPw(String id, String name, Model model) {
		
		String password = houseMemberService.findPw(id, name);
		
		model.addAttribute("user",password);
		
		return "/user/findPw";
		
	}

}
