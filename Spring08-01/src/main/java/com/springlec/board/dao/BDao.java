package com.springlec.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.springlec.board.dto.BDto;

public class BDao {
	
	
	DataSource dataSource;
	
	
	public BDao() {
		
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/MVC");
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	//게시판 내용 불러오기
	public ArrayList<BDto> list() {
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "SELECT * from mvc_board";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				String bDate = resultSet.getString("bDate");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate);
				
				dtos.add(dto);
						
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		return dtos;
	}
	
	//게시판 내용 추가
		public void insert(BDto bDto) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			
			try {
				connection = dataSource.getConnection();
				
				String query = "INSERT into mvc_board (bName, bTitle, bContent, bDate) values (?, ?, ?, now())";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, bDto.getbName());
				preparedStatement.setString(2, bDto.getbTitle());
				preparedStatement.setString(3, bDto.getbContent());
				
				preparedStatement.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			
		}

	
	//게시 내용 불러오기
		public BDto read(int bId) {
			
			BDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				
				String query = "SELECT * from mvc_board WHERE bId = " + bId;
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					
					String bName = resultSet.getString("bName");
					String bTitle = resultSet.getString("bTitle");
					String bContent = resultSet.getString("bContent");
					String bDate = resultSet.getString("bDate");
					
					dto = new BDto(bId, bName, bTitle, bContent, bDate);
					
							
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
				
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
					
			return dto;
		}	
	
		
	//게시판 내용 변
			public void update(BDto bDto) {
				
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				
				try {
					connection = dataSource.getConnection();
					
					String query = "Update mvc_board set bName = ?, bTitle = ?, bContent = ?, bDate = now() where bId = ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, bDto.getbName());
					preparedStatement.setString(2, bDto.getbTitle());
					preparedStatement.setString(3, bDto.getbContent());
					preparedStatement.setInt(4, bDto.getbId());
					
					preparedStatement.executeUpdate();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
				}
				
			}
			
		//게시판 내용 추가
		public void delete(int bId) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			
			try {
				connection = dataSource.getConnection();
				
				String query = "DELETE from mvc_board WHERE bId = " + bId;
				preparedStatement = connection.prepareStatement(query);
				
				
				preparedStatement.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			
		}

	
	
	
} ///class
