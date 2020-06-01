package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HouseMemberDao;
import com.ssafy.happyhouse.dto.HouseMember;


@Service
public class HouseMemberServiceImpl implements HouseMemberService {
	
	@Autowired
	private HouseMemberDao dao;
	

	
	@Override
	public HouseMember insert(String id, String password, String name, String address, String phone) {
		HouseMember member = new HouseMember(id, password, name, address, phone);
		
		try {
			int res = dao.insert(id, password, name, address, phone);
			if(res > 0) return member;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public HouseMember search(String id) {
		try {
			return dao.search(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<HouseMember> searchAll() {
		try {
			return dao.searchAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int update(String id, String password, String name, String address, String phone) {
		try {
			System.out.println("housememberserviceimpl");
			return dao.update(id, password, name, address, phone);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(String id) {
		try {
			return dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public HouseMember login(String id, String password) throws SQLException {
		try {
			return dao.login(id, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findPw(String id, String name) {
		try {
			return dao.findPw(id, name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
