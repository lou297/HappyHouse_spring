package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.QnA;

@Mapper
@Repository
public interface QnADao {
	List<QnA> selectQnA();
	
}
