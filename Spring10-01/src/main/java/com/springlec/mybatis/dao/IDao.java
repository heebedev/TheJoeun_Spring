package com.springlec.mybatis.dao;

import java.util.ArrayList;

import com.springlec.mybatis.dto.BDto;

public interface IDao {
	
	//select list
	public ArrayList<BDto> listDao();
	
	//insert
	public void writeDao(String bName, String bTitle, String bContent, String bDate);
	
	//select content_view
	public BDto contentViewDao(String bId); // BDto로 해야함!!
	
	//update
	public void modifyDao(String bName, String bTitle, String bContent, String bId);
	
	//delete
	public void deleteDao(String bId);
}
