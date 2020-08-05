package com.blgy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.blgy.dto.CmtDto;
import com.blgy.dto.PrdDto;
import com.blgy.dto.TextDto;
import com.blgy.dto.UserDto;



public class Dao2 {

	DataSource dataSource;
	
	public Dao2() {
	
			// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource =(DataSource) context.lookup("java:comp/env/jdbc/blgy");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public PrdDto pdDetail(int prdseq, int myseq) {
		
		//System.out.println("두번째" + rentSeq); OK
		
		PrdDto dtos = new PrdDto();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			//System.out.println("connection"); OK
			String query = "select p.uploaderseq, u.nickname, p.title, p.price, p.date1, p.date2, p.info, p.image1, p.hash, p.insertdate, p.xaxis, p.yaxis, p.view\n" + 
					"	from product p, userdata u where p.uploaderseq = u.userseq AND p.prdseq = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, prdseq);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				
				int uploaderseq = resultSet.getInt("uploaderseq");
				String nickname = resultSet.getString("nickname");
				String title = resultSet.getString("title");
				String price = resultSet.getString("price");
				String date1 = resultSet.getString("date1");
				String date2 =resultSet.getString("date2");
				String info = resultSet.getString("info");
				String image1 = resultSet.getString("image1");
				String hash = resultSet.getString("hash");
				String insertdate =resultSet.getString("insertdate");
				String xaxis = resultSet.getString("xaxis");
				String yaxis = resultSet.getString("yaxis");
				int view = resultSet.getInt("view");
				int uploaderCheck = 0;
				
//				System.out.println(rentSeq);
//				System.out.println(pName);
//				System.out.println(rentEndPeriod);   OK
				
				if (uploaderseq == myseq) {
					uploaderCheck = 1;
				}
				
				dtos.setPrdseq(prdseq);
				dtos.setUploaderseq(uploaderseq);
				dtos.setNickname(nickname);
				dtos.setTitle(title);
				dtos.setPrice(price);
				dtos.setInfo(info);
				dtos.setInsertdate(insertdate);
				dtos.setDate1(date1);
				dtos.setDate2(date2);
				dtos.setImage1(image1);
				dtos.setHash(hash);
				dtos.setXaxis(xaxis);
				dtos.setYaxis(yaxis);
				dtos.setView(view);
				dtos.setUploaderCheck(uploaderCheck);
				

			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
				//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
		
	}
	public void SendMessage(int myseq, int userseq, String message) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		
		try {
			connection = dataSource.getConnection();
			//System.out.println("connection"); OK
			String query = "insert message (seq_receive, seq_send, message, insertdate) values (?, ? , ?, now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userseq);
			preparedStatement.setInt(2, myseq);
			preparedStatement.setString(3, message);
			
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
				//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
		
	public UserDto usInfo(String nickname) {
				
				//System.out.println("두번째" + rentSeq); OK
				
				UserDto dtos = new UserDto();
				//System.out.println(userseq);
				
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				try {
					connection = dataSource.getConnection();
					//System.out.println("connection"); OK
					String query = "SELECT userseq FROM userdata where nickname = ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, nickname);
					resultSet = preparedStatement.executeQuery();
					
					if (resultSet.next()) {
						
						int userseq = resultSet.getInt("userseq");
						
						dtos.setUserseq(userseq);
						dtos.setNickname(nickname);
						
					}
				} catch(Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(resultSet != null) resultSet.close();
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
						
						//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				return dtos;
				
			}
		
	public ArrayList<TextDto> messageList(int myseq, String selection, String search, String searchText) {
		
		ArrayList<TextDto> dtos = new ArrayList<TextDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = null;
		
		try {
			
			connection = dataSource.getConnection();
			if (selection == null) {
				selection = "total";
			}
			
	
			switch(selection) {
			case "send" : query = "select d.nick_receive, u.nickname as nick_send, d.message, d.insertdate from \n" + 
					"(SELECT u.nickname as nick_receive, m.seq_send, m.message, m.insertdate\n" + 
					"from userdata u, message m where m.seq_receive = u.userseq) d, userdata u\n" + 
					"where d.seq_send = u.userseq AND d.seq_send = " + myseq; 
			//센
				break;
			case "receive" : query = "select u.nickname as nick_receive, d.nick_send, d.message, d.insertdate from \n" + 
					"(SELECT m.seq_receive, u.nickname as nick_send, m.message, m.insertdate\n" + 
					"from userdata u, message m where m.seq_send = u.userseq) d, userdata u\n" + 
					"where d.seq_receive = u.userseq AND d.seq_receive = " + myseq; //리시
				break;
			case "total"  : query = "select u.nickname as nick_receive, d.nick_send, d.message, d.insertdate from \n" + 
					"(SELECT m.seq_receive, u.nickname as nick_send, m.message, m.insertdate\n" + 
					"from userdata u, message m where m.seq_send = u.userseq AND (m.seq_send = "+ myseq +" or m.seq_receive = "+ myseq +")) d, userdata u\n" + 
					"where d.seq_receive = u.userseq";
				break;
			}
			
			
			if (search != null) {
				switch(search) {
				case "nick_send" : query = "select u.nickname as nick_receive, d.nick_send, d.message, d.insertdate from \n" + 
						"(SELECT m.seq_receive, u.nickname as nick_send, m.message, m.insertdate\n" + 
						"FROM message m, userdata u WHERE m.seq_send = u.userseq) d, userdata u\n" + 
						"where d.seq_receive = u.userseq AND seq_receive = " + myseq + " AND nick_send like '%" + searchText + "%'"; 
				break;
				case "nick_receive" : query = "select d.nick_receive, u.nickname as nick_send, d.message, d.insertdate from \n" + 
						"(SELECT u.nickname as nick_receive, m.seq_send, m.message, m.insertdate\n" + 
						"FROM message m, userdata u WHERE m.seq_receive = u.userseq) d, userdata u\n" + 
						"where d.seq_send = u.userseq AND d.seq_send = "+ myseq +" AND nick_receive like '%" + searchText + "%'";
				break;
				case "message" : query = "select d.nick_receive, u.nickname as nick_send, d.message, d.insertdate from \n" + 
						"(SELECT u.nickname as nick_receive, m.seq_send, m.message, m.insertdate\n" + 
						"FROM message m, userdata u WHERE m.seq_receive = u.userseq and (m.seq_send = " + myseq + " or m.seq_receive = " + myseq + 
						")) d, userdata u where d.seq_send = u.userseq AND message like '%" + searchText + "%'";
				break;				
				}
			}
			System.out.println(query);
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String nickname_send = resultSet.getString("nick_send");
				String nickname_receive = resultSet.getString("nick_receive");
				String message = resultSet.getString("message");
				String insertdate = resultSet.getString("insertdate");
				
				
				TextDto dto = new TextDto(nickname_send, nickname_receive, message, insertdate);
				dtos.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
				//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
		
	}
	
	public TextDto msgDetail(int textseq) {
		
		//System.out.println("두번째" + rentSeq); OK
		
		TextDto dtos = new TextDto();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			//System.out.println("connection"); OK
			String query = "SELECT textseq, nick_send, nick_receive, message, insertdate FROM message where textseq = " + textseq;
			
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				
				String nick_send = resultSet.getString("nick_send");
				String nick_receive = resultSet.getString("nick_receive");
				String message = resultSet.getString("message");
				String insertdate = resultSet.getString("insertdate");
				
				
				dtos.setTextseq(textseq);
				dtos.setNickname_send(nick_send);
				dtos.setNickname_receive(nick_receive);
				dtos.setMessage(message);
				dtos.setDate(insertdate);

			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
				//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
		
	}
	
	
	public ArrayList<CmtDto> cmtDetail(int prdseq) {
		
		ArrayList<CmtDto> dtos = new ArrayList<CmtDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "SELECT c.cmtseq, c.userseq, u.nickname, c.comment, c.insertdate from userdata u, comment c where c.userseq = u.userseq AND c.readft = 1 AND prdseq = " + prdseq;
		
		try {
			
			connection = dataSource.getConnection();
			
			//System.out.println(query);
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int cmtseq = resultSet.getInt("cmtseq");
				int userseq = resultSet.getInt("userseq");
				String nickname = resultSet.getString("nickname");
				String comment = resultSet.getString("comment");
				String insertdate = resultSet.getString("insertdate");
				int userCheck = 0;
				
				CmtDto dto = new CmtDto(cmtseq, userseq, nickname, comment, insertdate, userCheck);
				dtos.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
				//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
		
	}
	
	public void AddComment(int prdseq, int myseq, String comment) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		
		try {
			connection = dataSource.getConnection();
			//System.out.println("connection"); OK
			String query = "insert comment (prdseq, userseq, comment, insertdate) values (?, ?, ?, now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, prdseq);
			preparedStatement.setInt(2, myseq);
			preparedStatement.setString(3, comment);
			
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
		
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
				//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void borrowAct(int prdseq, int userseq, String startDate, String endDate) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		System.out.println("여기");
		try {
			connection = dataSource.getConnection();
			//System.out.println("connection"); OK
			String query = "insert borrow (prdseq, userseq, date1, date2, insertdate) values (?, ?, ?, ?, now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, prdseq);
			preparedStatement.setInt(2, userseq);
			preparedStatement.setString(3, startDate);
			preparedStatement.setString(4, endDate);
			
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
				//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public String pdlike(int prdseq, int myseq) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String heart = null;
		
		
		
		try {
			connection = dataSource.getConnection();
			//System.out.println("connection"); OK
			String query = "SELECT likeseq, liked from interaction where prdseq = ? AND userseq = ? order by likeseq DESC" ;
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, prdseq);
			preparedStatement.setInt(2, myseq);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				heart = "♥️" ;
			} else {
				heart = "🖤" ;			
			}
			
			System.out.println(heart);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
				//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return heart;
		
	}
		
	public void commentRUD(int cmtseq, int userseq, int prdseq, String comment) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			//System.out.println("connection"); OK
			
			String query = "UPDATE comment set readft = 0 where cmtseq = " + cmtseq;
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
			

			if (prdseq > 0 ) {
				
				query = "insert comment (prdseq, userseq, comment, insertdate) values \n" +
						"(?, ?, ?, now())";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, prdseq);
				preparedStatement.setInt(2, userseq);
				preparedStatement.setString(3, comment);
				
				preparedStatement.executeUpdate();
				
	
				
		}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
				//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public CmtDto cmtCheck(int cmtseq) {
			
			CmtDto dtos = null;
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				
				connection = dataSource.getConnection();
				
				String query = "SELECT c.prdseq, u.userseq, u.nickname, c.comment, c.insertdate FROM comment c, userdata u where c.readft = 1 \n" + 
						"AND c.userseq = u.userseq AND cmtseq = " + cmtseq;
				//System.out.println(query);
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				
				while(resultSet.next()) {
					int prdseq = resultSet.getInt("prdseq");
					int userseq = resultSet.getInt("userseq");
					String nickname = resultSet.getString("nickname");
					String comment = resultSet.getString("comment");
					String insertdate = resultSet.getString("insertdate");
		
					
					dtos = new CmtDto(cmtseq, userseq, prdseq, nickname, comment, insertdate);

				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
					//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtos;
			
		}
	
	public void prdDel(int prdseq) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			//System.out.println("여기여기");
			try {
				connection = dataSource.getConnection();
				//System.out.println("connection"); OK
				
				String query = "DELETE from product where prdseq = " + prdseq;
				
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
	
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
					//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	
	public void prdRU(int prdseq, String title, String price, String date1, String date2, String hash, String info) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				//System.out.println("connection"); OK
				
				String query = "UPDATE product set title = ?, price = ?, date1 = ?, date2 = ?, info = ?, hash = ?, insertdate = now() where prdseq = " + prdseq;
				
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, title);
				preparedStatement.setString(2, price);
				preparedStatement.setString(3, date1);
				preparedStatement.setString(4, date2);
				preparedStatement.setString(5, info);
				preparedStatement.setString(6, hash);
				
				preparedStatement.executeUpdate();
	
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
	
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
					//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	
	public ArrayList<CmtDto> cmtDetail(int prdseq, int myseq) {
			
			ArrayList<CmtDto> dtos = new ArrayList<CmtDto>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String query = "SELECT c.cmtseq, c.userseq, u.nickname, c.comment, c.insertdate from userdata u, comment c where c.userseq = u.userseq AND c.readft = 1 AND prdseq = " + prdseq;
			
			try {
				
				connection = dataSource.getConnection();
				
				//System.out.println(query);
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int cmtseq = resultSet.getInt("cmtseq");
					int userseq = resultSet.getInt("userseq");
					String nickname = resultSet.getString("nickname");
					String comment = resultSet.getString("comment");
					String insertdate = resultSet.getString("insertdate");
					int userCheck = 0;
					
					if (userseq == myseq) {
						userCheck = 1;
					}
					
					CmtDto dto = new CmtDto(cmtseq, userseq, nickname, comment, insertdate, userCheck);
					dtos.add(dto);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
					//선언한 순서 반대로 클로즈 해주어야 에러 안걸림
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtos;
			
		}
		
	
}