package com.springlec.mybatis.dao;

import java.util.ArrayList;

import com.springlec.mybatis.dto.ContentDto;

public interface IDao {

	//list select
	public ArrayList<ContentDto> listDao();
	
	//insert
	public void writeDao(String mWriter, String mContent); //writeForm에 있는 mWriter, mContent
	
	//delete
	public void deleteDao(String mId);
}
