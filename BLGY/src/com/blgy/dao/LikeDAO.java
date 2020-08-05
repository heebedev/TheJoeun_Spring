package com.blgy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LikeDAO {
		DataSource dataSource;
		
		public LikeDAO() {
			try {
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/blgy");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public int StringToInt(String liked2) {
			int liked = 0;
			if(liked2.equals("❤️")){
				liked = 1;
			}return liked;
		}
		public void likeInsert(int userseq, int prdseq, String liked2) {
			int liked = StringToInt(liked2);
			Connection connection = null;
			PreparedStatement preparedStatement = null;
				try {		
					if(liked == 1) {
						connection = dataSource.getConnection();
						String query = "delete from interaction where prdseq = " + prdseq + " and userseq = " + userseq;		
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.executeUpdate();
						System.out.println(query);
					}else {
						connection = dataSource.getConnection();
						String query = "insert into interaction (userseq, prdseq, liked, lastaction) values(?, ?, ?, now())";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setInt(1, userseq);
						preparedStatement.setInt(2, prdseq);
						preparedStatement.setInt(3, 1);	
					
						preparedStatement.executeUpdate();
						System.out.println(query);
						
				
				}
					
			}catch(Exception e) {
			e.printStackTrace();
			}finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}

}
