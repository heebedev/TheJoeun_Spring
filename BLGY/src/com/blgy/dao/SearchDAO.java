package com.blgy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.blgy.dto.SearchDTO;

public class SearchDAO {

	DataSource dataSource;
	
	public SearchDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/blgy");
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public String GetLiked(int prdseq, int userseq) {
		String liked2 = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
		String query = "select count(i.liked) as liked from interaction as i where i.prdseq = " + prdseq + " and userseq = " + userseq;
		preparedStatement = connection.prepareStatement(query);
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) { // 데이터 있을때 까지 가져와라 
			int liked = resultSet.getInt("liked");
			if(liked == 1) {
				liked2 = "❤️";
			}else {
				liked2 = "🖤";
			}}
		
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					//뒤에꺼부터 거꾸로 꺼줘야 함
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return liked2;
			
		}
	
	public ArrayList<SearchDTO> SearchList(String Keyword, String Startdate1, String Finishdate2, int userseq, String select){
		
		ArrayList<SearchDTO> searchDTOs = new ArrayList<SearchDTO>(); // 선언
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			//sql정보 불러오기
			String query = "select p.prdseq, p.uploaderseq, p.title, p.price, p.date1, p.date2, p.image1, p.view from product as p ";
			String guery2 = "where (p.hash like '%" + Keyword + "%' or p.title like '%" + Keyword + "%') and Date(date1) <= date('" + Startdate1 +"') and Date(date2) >= date('" + Finishdate2 + "') order by p.insertdate";
			String query3 = "where (p.hash like '%" + Keyword + "%' or p.title like '%" + Keyword + "%') and Date(date1) <= date('" + Startdate1 +"') and Date(date2) >= date('" + Finishdate2 + "') order by view desc";
			
			if(select.equals("조회수순")) {
				preparedStatement = connection.prepareStatement(query+query3);
			}else {
				preparedStatement = connection.prepareStatement(query+guery2);
			}
			resultSet = preparedStatement.executeQuery();  // 여기까지 sql에서 결과 나온 상태 
			String liked2 = null;
			// 자바로 가져옴 
			while(resultSet.next()) { // 데이터 있을때 까지 가져와라 
				
				int prdseq = resultSet.getInt("prdseq");
				int uploaderseq = resultSet.getInt("uploaderseq");
				String title = resultSet.getString("title");
				String price = resultSet.getString("price");
				String date1 = resultSet.getString("date1");
				String date2 = resultSet.getString("date2");
				String image1 = resultSet.getString("image1");
				int view = resultSet.getInt("view");
				liked2 = GetLiked(prdseq,userseq);
				
				// PrDto Bean에 어레이리스트로 저장////////////////////여기해야함.
				SearchDTO searchDTO = new SearchDTO(prdseq, uploaderseq, title, price, date1, date2, image1, view, liked2);
				
				searchDTOs.add(searchDTO);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//뒤에꺼부터 거꾸로 꺼줘야 함
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return searchDTOs;
	}
	
	
}
