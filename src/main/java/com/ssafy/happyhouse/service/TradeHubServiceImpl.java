package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dao.TradeHubDao;
import com.ssafy.happyhouse.dto.TradeHub;

public class TradeHubServiceImpl implements TradeHubService{
	
	TradeHubDao tradeHubDao;
	
	

	public TradeHubServiceImpl() {
//		tradeHubDao = new TradeHubDaoImpl();
	}



	@Override
	public List<TradeHub> findShopByDongName(String dongName) throws Exception {
		if(dongName == null) {
			throw new Exception();
		}
		return tradeHubDao.findShopByDongName(dongName);
	}



	@Override
	public List<TradeHub> findShopByCategory(String bigCategoryName) throws Exception {
		if(bigCategoryName == null) {
			throw new Exception();
		}
		return tradeHubDao.findShopByCategory(bigCategoryName);
	}



	@Override
	public List<String> showShopCategorys() throws Exception {
		
		return tradeHubDao.showShopCategorys();
	}



	@Override
	public List<String> showShopDongNames() throws Exception {

		return tradeHubDao.showShopDongNames();
	}
	
	@Override
	public List<TradeHub> loadAllShops() throws Exception {
		// TODO Auto-generated method stub
		return tradeHubDao.loadAllShops();
	}

}
