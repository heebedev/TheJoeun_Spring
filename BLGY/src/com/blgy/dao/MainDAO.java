package com.blgy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.blgy.dto.MainDTO;
import com.blgy.dto.SearchDTO;

public class MainDAO {
	DataSource dataSource;
	
	public MainDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/blgy");
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<MainDTO> MainList(){
		
		ArrayList<MainDTO> mainDTOs = new ArrayList<MainDTO>(); // 선언
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			//sql정보 불러오기
			String query = "select prdseq, uploaderseq, image1, title, price from product order by insertdate";
			
			preparedStatement = connection.prepareStatement(query );
			resultSet = preparedStatement.executeQuery();  // 여기까지 sql에서 결과 나온 상태 
			// 자바로 가져옴 
			while(resultSet.next()) { // 데이터 있을때 까지 가져와라 
				int prdseq = resultSet.getInt("prdseq");
				int uploaderseq = resultSet.getInt("uploaderseq");
				String image1 = resultSet.getString("image1");
				String title = resultSet.getString("title");
				String price = resultSet.getString("price");
				
				// PrDto Bean에 어레이리스트로 저장////////////////////여기해야함.
				MainDTO mainDTO = new MainDTO(prdseq, uploaderseq, image1, title, price);
				
				mainDTOs.add(mainDTO);
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
		return mainDTOs;
	}
}
