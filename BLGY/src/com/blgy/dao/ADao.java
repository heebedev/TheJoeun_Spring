package com.blgy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.blgy.dto.APrdDto;
import com.blgy.dto.AUserDto;
import com.blgy.dto.PrdDto;





public class ADao {

	static DataSource dataSource;
	
	//DB context 설정
	public ADao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			//dataSource =(DataSource) context.lookup("java:comp/env/jdbc/blgy");
			dataSource =(DataSource) context.lookup("java:comp/env/jdbc/blgy");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Method
	
	//AUserList
	public static ArrayList<AUserDto> AUserList() {
		ArrayList<AUserDto> aUserDtos = new ArrayList<AUserDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select u.userseq, u.name, u.nickname, count(p.uploaderseq) as countPrd from userdata as u left outer join product as p on u.userseq = p.uploaderseq group by u.userseq;";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int userseq = resultSet.getInt("userseq");
				String name = resultSet.getString("name");
				String nickname = resultSet.getString("nickname");
				int countPrd = resultSet.getInt("countPrd");
				AUserDto aUserDto = new AUserDto(userseq, name, nickname, countPrd);
				aUserDtos.add(aUserDto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return aUserDtos;
	}

	//어드민 클릭한 회원정보 불러오기
	public AUserDto AdminViewUserInfo(String getUserseq) {
		AUserDto auserdto = null;
	
		// 변수선언 
		Connection connection = null;
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
	
	
		try {
			// 연결 
			connection = dataSource.getConnection();
		
			String query = "select * from userdata where userseq = ?"; // 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(getUserseq));
			resultSet = preparedStatement.executeQuery();  // 여기까지 sql에서 결과 나온 상태 
		
		// 자바로 가져옴 
			if(resultSet.next()) { // 
			
				int userseq = resultSet.getInt("userseq"); 
				String email = resultSet.getString("email");
				String name = resultSet.getString("name");
				String nickname = resultSet.getString("nickname");
				String birthdate = resultSet.getString("birthdate");
				String telno = resultSet.getString("telno");
				String address = resultSet.getString("address");
				String addressdt = resultSet.getString("addressdt");
				String xaxis = resultSet.getString("xaxis");
				String yaxis = resultSet.getString("yaxis");
				String pw = resultSet.getString("pw");
				String insertdate = resultSet.getString("insertdate");
				
				auserdto = new AUserDto(userseq, email, name, nickname, birthdate, telno, address, addressdt, xaxis, yaxis, pw, insertdate);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//뒤에꺼부터 거꾸로 꺼줘야 오류안남
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return auserdto;
	
	}
	
	//어드민 회원정보 수정 
	public void AdminUserModify(String userseq, String newname, String newnickname, String newpw, String newbirthdate, String newemail, String newtelno, String newaddress, String newaddressdt) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update userdata set name = ?, nickname = ?, pw=?, birthdate=?, email=?, telno=?, address=?, addressdt=? where userseq = ?;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, newname);
			preparedStatement.setString(2, newnickname);
			preparedStatement.setString(3, newpw);
			preparedStatement.setString(4, newbirthdate);
			preparedStatement.setString(5, newemail);
			preparedStatement.setString(6, newtelno);
			preparedStatement.setString(7, newaddress);
			preparedStatement.setString(8, newaddressdt);
			preparedStatement.setString(9, userseq);
			preparedStatement.executeUpdate(); //실행 
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	
	//회원정보 삭제 
	public void AdminUserDelete(String userseq) {
		
		// 변수선언 
		Connection connection = null;
		PreparedStatement preparedStatement = null; 	
		
		try {
			connection = dataSource.getConnection();
			
			String query = "delete from userdata where userseq = ?;"; 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userseq);
			preparedStatement.executeUpdate(); 
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//뒤에꺼부터 거꾸로 꺼줘야 함
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
	}
	
	public String AdminMainCountUser(){
		String countTodayUser = null;
	
			// 변수선언 
			Connection connection = null;
			PreparedStatement preparedStatement = null; 
			ResultSet resultSet = null;
		
		
			try {
				// 연결 
				connection = dataSource.getConnection();
			
				String query = "select count(userseq) as todayUser from userdata where DATE(insertdate)= date(curdate());"; // 
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();  // 여기까지 sql에서 결과 나온 상태 
			
			// 자바로 가져옴 
				if(resultSet.next()) { // 
					countTodayUser = resultSet.getString("todayUser");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					//뒤에꺼부터 거꾸로 꺼줘야 오류안남
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	
		return countTodayUser;
	}
	
	
	public String AdminMainCountProduct(){
		String countTodayProduct = null;
	
			// 변수선언 
			Connection connection = null;
			PreparedStatement preparedStatement = null; 
			ResultSet resultSet = null;
		
		
			try {
				// 연결 
				connection = dataSource.getConnection();
			
				String query = "select count(prdseq) as todayProduct from product where DATE(insertdate)= date(curdate());"; // 
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();  // 여기까지 sql에서 결과 나온 상태 
			
			// 자바로 가져옴 
				if(resultSet.next()) { // 
					countTodayProduct = resultSet.getString("todayProduct");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					//뒤에꺼부터 거꾸로 꺼줘야 오류안남
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	
		return countTodayProduct;
	}
	
	public String AdminMainCountBorrow(){
		String countTodayBorrow = null;
	
			// 변수선언 
			Connection connection = null;
			PreparedStatement preparedStatement = null; 
			ResultSet resultSet = null;
		
		
			try {
				// 연결 
				connection = dataSource.getConnection();
			
				String query = "select count(rentseq) as todayBorrow from borrow where DATE(insertdate)= date(curdate());"; // 
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();  // 여기까지 sql에서 결과 나온 상태 
			
			// 자바로 가져옴 
				if(resultSet.next()) { // 
					countTodayBorrow = resultSet.getString("todayBorrow");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					//뒤에꺼부터 거꾸로 꺼줘야 오류안남
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	
		return countTodayBorrow;
	}
	
	//AProductList
		public  ArrayList<APrdDto> AProductList() {
			ArrayList<APrdDto> aProductDtos = new ArrayList<APrdDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "select p.*, u.name, u.nickname, u.email from product as p left outer join userdata as u on p.uploaderseq = u.userseq;";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int prdseq = resultSet.getInt("prdseq");
					int uploaderseq = resultSet.getInt("uploaderseq");
					String title = resultSet.getString("title");
					String price = resultSet.getString("price");
					String date1 = resultSet.getString("date1");
					String date2 = resultSet.getString("date2");
					String info = resultSet.getString("info");
					String image1 = resultSet.getString("image1");
					String hash = resultSet.getString("hash");
					String xaxis = resultSet.getString("xaxis");
					String yaxis = resultSet.getString("yaxis");
					String view = resultSet.getString("view");
					String name = resultSet.getString("name");
					String nickname = resultSet.getString("nickname");
					String email = resultSet.getString("email");
					
					APrdDto aProductDto = new APrdDto(prdseq, uploaderseq, title, price, date1, date2, info, image1, hash, xaxis, yaxis, view, name, nickname, email);
					aProductDtos.add(aProductDto);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return aProductDtos;
		}
		
		
		public PrdDto AdminViewPrdInfo(String getPrdseq) {
			PrdDto prddto = null;
		
			// 변수선언 
			Connection connection = null;
			PreparedStatement preparedStatement = null; 
			ResultSet resultSet = null;
		
		
			try {
				// 연결 
				connection = dataSource.getConnection();
			
				String query = "select * from product where prdseq = ?"; // 
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(getPrdseq));
				resultSet = preparedStatement.executeQuery();  // 여기까지 sql에서 결과 나온 상태 
			
			// 자바로 가져옴 
				if(resultSet.next()) { // 
				
					int prdseq = resultSet.getInt("prdseq"); 
					int uploaderseq = resultSet.getInt("uploaderseq"); 
					String title = resultSet.getString("title");
					String price = resultSet.getString("price");
					String date1 = resultSet.getString("date1");
					String date2 = resultSet.getString("date2");
					String info = resultSet.getString("info");
					String image1 = resultSet.getString("image1");
					String hash = resultSet.getString("hash");
					String xaxis = resultSet.getString("xaxis");
					String yaxis = resultSet.getString("yaxis");
					String insertdate = resultSet.getString("insertdate");
					
					prddto = new PrdDto(prdseq, uploaderseq, title, price, info, insertdate, date1, date2, image1, hash, xaxis, yaxis, insertdate);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					//뒤에꺼부터 거꾸로 꺼줘야 오류안남
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return prddto;
		
		}

		
		public void AdminPrdModify(String prdseq, String uploaderseq, String newtitle, String newprice, String newdate1, String newdate2, String newinfo, String newhash, String newxaxis, String newyaxis, String newupdatedate) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				connection = dataSource.getConnection();
				String query = "update product set title = ?, price = ?, date1=?, date2=?, info=?, hash=? where prdseq = ?;";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, newtitle);
				preparedStatement.setString(2, newprice);
				preparedStatement.setString(3, newdate1);
				preparedStatement.setString(4, newdate2);
				preparedStatement.setString(5, newinfo);
				preparedStatement.setString(6, newhash);
				preparedStatement.setString(7, prdseq);
				preparedStatement.executeUpdate(); //실행 
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
		
		
	public void AdminProductDelete(String prdseq) {
			
			// 변수선언 
			Connection connection = null;
			PreparedStatement preparedStatement = null; 	
			
			try {
				connection = dataSource.getConnection();
				
				String query = "delete from product where prdseq = ?;"; 
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, prdseq);
				preparedStatement.executeUpdate(); 
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					//뒤에꺼부터 거꾸로 꺼줘야 함
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		
			
		}
	//고객검색 결과 
	public ArrayList<AUserDto> AUserSearchList(String selection, String adminUserSearchText) {
		ArrayList<AUserDto> aUserSearchDtos = new ArrayList<AUserDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select u.userseq, u.name, u.nickname, count(p.uploaderseq) as countPrd from userdata as u left outer join product as p on u.userseq = p.uploaderseq where " + selection + " like '%" + adminUserSearchText + "%' group by u.userseq;";
			
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int userseq = resultSet.getInt("userseq");
				String name = resultSet.getString("name");
				String nickname = resultSet.getString("nickname");
				int countPrd = resultSet.getInt("countPrd");
				AUserDto aUserSearchDto = new AUserDto(userseq, name, nickname, countPrd);
				aUserSearchDtos.add(aUserSearchDto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return aUserSearchDtos;
	}
	
	//상품검색 결과 
		public ArrayList<APrdDto> AProductSearchList(String selection, String adminProductSearchText) {
			ArrayList<APrdDto> aProductSearchDtos = new ArrayList<APrdDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select p.*, u.name, u.nickname, u.email from product as p left outer join userdata as u on p.uploaderseq = u.userseq where "+ selection + " like '%" + adminProductSearchText + "%';";
				
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int prdseq = resultSet.getInt("prdseq");
					int uploaderseq = resultSet.getInt("uploaderseq");
					String title = resultSet.getString("title");
					String price = resultSet.getString("price");
					String date1 = resultSet.getString("date1");
					String date2 = resultSet.getString("date2");
					String info = resultSet.getString("info");
					String image1 = resultSet.getString("image1");
					String hash = resultSet.getString("hash");
					String xaxis = resultSet.getString("xaxis");
					String yaxis = resultSet.getString("yaxis");
					String view = resultSet.getString("view");
					String name = resultSet.getString("name");
					String nickname = resultSet.getString("nickname");
					String email = resultSet.getString("email");
					
					APrdDto aProductSearchDto = new APrdDto(prdseq, uploaderseq, title, price, date1, date2, info, image1, hash, xaxis, yaxis, view, name, nickname, email);
					aProductSearchDtos.add(aProductSearchDto);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return aProductSearchDtos;
		}
		
	
	
	
} //--------------