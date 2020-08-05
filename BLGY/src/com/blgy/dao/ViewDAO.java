package com.blgy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ViewDAO {

DataSource dataSource;
	
	public ViewDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/blgy");
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	public void updateView(int prdseq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
			try {		
				connection = dataSource.getConnection();
				String query = "update product set view = view + 1 where prdseq = " + prdseq;	
				System.out.println(query);
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.executeUpdate();
				
			
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
