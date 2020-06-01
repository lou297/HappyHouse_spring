package com.ssafy.happyhouse.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.HouseMember;

@Mapper
@Repository
public interface HouseMemberDao {
	// 회원 가입
	public int insert(String id, String password, String name, String address, String phone) throws SQLException;

	// 로그인
	public HouseMember login(String id, String password) throws SQLException;

	// 회원 정보 조회
	public HouseMember search(String id) throws SQLException;

	public List<HouseMember> searchAll() throws SQLException;

	// 회원 정보 수정
	public int update(String id, String password, String name, String address, String phone) throws SQLException;

	// 회원 정보 삭제
	public int delete(String id) throws SQLException;

	public String findPw(String id, String name) throws SQLException;
}
