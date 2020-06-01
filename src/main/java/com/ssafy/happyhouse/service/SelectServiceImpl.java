package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import com.ssafy.happyhouse.dao.SelectDao;
import com.ssafy.happyhouse.dto.HouseInfo;
import com.ssafy.happyhouse.dto.SidoCode;

public class SelectServiceImpl implements SelectService{
	private SelectDao dao;

	public SelectServiceImpl() {
//		dao =  new SelectDaoImpl();
	}

	@Override
	public ArrayList<SidoCode> selectSido() throws Exception {
		ArrayList<SidoCode> list = dao.selectSido();
		return list;
	}

	@Override
	public ArrayList<SidoCode> selectGugun(String sido) throws Exception {
		ArrayList<SidoCode> list = dao.selectGugun(sido);
		return list;
	}

	@Override
	public ArrayList<HouseInfo> selectDong(String gugun) throws Exception {
		ArrayList<HouseInfo> list = dao.selectDong(gugun);
		return list;
	}

	@Override
	public ArrayList<HouseInfo> selectApt(String dong) throws Exception {
		ArrayList<HouseInfo> list = dao.selectApt(dong);
		return list;
	}
}
