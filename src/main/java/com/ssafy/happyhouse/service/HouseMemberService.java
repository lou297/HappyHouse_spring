package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.HouseMember;

public interface HouseMemberService {
	public HouseMember insert(String id, String password, String name, String address, String phone);
	public HouseMember login(String id, String password) throws SQLException;
	
	public HouseMember search(String id);
	public List<HouseMember> searchAll();
	
	public int update(String id, String password, String name, String address, String phone);
	
	public int delete(String id);
	public String findPw(String id, String name);
}
