package com.springlec.mybatisAddressEx.dao;

import java.util.ArrayList;

import com.springlec.mybatisAddressEx.dto.AddDto;


public interface ADao {
	
	//list select
	public ArrayList<AddDto> addressDao();
	
	//insert
	public void writeDao(String name, String telno, String address, String email, String relation); 
	
	//delete
	public void deleteDao(int seq);
	
	//detail select	
	public AddDto detailDao(int seq);
	
	//update
	public void updateDao(int seq, String name, String telno, String address, String email, String relation); 
	
	//listQuery
	public ArrayList<AddDto> listQuery(String query, String content);
	

}
