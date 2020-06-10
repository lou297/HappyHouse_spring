package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.QnADao;
import com.ssafy.happyhouse.dto.QnA;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private QnADao dao;

	@Override
	public List<QnA> retrieveQnA() {
		// TODO Auto-generated method stub
		return dao.selectQnA();
	}

}
