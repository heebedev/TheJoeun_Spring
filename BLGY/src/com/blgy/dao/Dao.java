package com.blgy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.net.ftp.FTPClient;

import com.blgy.dto.BrwDto;
import com.blgy.dto.LikeDTO;
import com.blgy.dto.LogInDto;
import com.blgy.dto.PrdDto;
import com.blgy.dto.SignUp;
import com.blgy.dto.UserDto;


public class Dao {
	
	DataSource dataSource;
	
	public Dao() {
		try {
			Context context = new InitialContext();
			dataSource =(DataSource) context.lookup("java:comp/env/jdbc/blgy");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(String email, String name, String nickname, String birthdate, String telno, String address, String addressdt, String xaxis, String yaxis, String pw) {
		Connection conn =null;
		PreparedStatement ps =null;
		try {
			conn= dataSource.getConnection();
			String A = "INSERT INTO userdata(email, name, nickname, birthdate, telno, address, addressdt, xaxis, yaxis, pw, insertdate) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
			ps=conn.prepareStatement(A);
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, nickname);
			ps.setString(4, birthdate);
			ps.setString(5, telno);
			ps.setString(6, address);
			ps.setString(7, addressdt);
			ps.setString(8, xaxis);
			ps.setString(9, yaxis);
			ps.setString(10, pw);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(ps !=null) ps.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public void update(String email, String nickname, String password, String telno, String address, String addressdt, String xaxis, String yaxis) {
		Connection conn =null;
		PreparedStatement ps =null;
		try {
			conn= dataSource.getConnection();
			String A = "update userdata set nickname=?, pw = ?, telno = ?, address = ?, addressdt = ?, xaxis = ?, yaxis = ? where email = ?";
			ps=conn.prepareStatement(A);
			ps.setString(1, nickname);
			ps.setString(2, password);
			ps.setString(3, telno);
			ps.setString(4, address);
			ps.setString(5, addressdt);
			ps.setString(6, xaxis);
			ps.setString(7, yaxis);
			ps.setString(8, email);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(ps !=null) ps.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public SignUp read(String userseq) {
		SignUp dto = null;
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn= dataSource.getConnection();
			String A = "select email, name, nickname, birthdate, telno, address, addressdt, xaxis, yaxis, pw from userdata where userseq= ?";
			ps=conn.prepareStatement(A);
			ps.setString(1, userseq);
			rs=ps.executeQuery();
			
			rs.next();
			
			String email=rs.getString(1);
			String name=rs.getString(2);
			String nickname=rs.getString(3);
			String birthdate=rs.getString(4);
			String telno=rs.getString(5);
			String address=rs.getString(6);
			String addressdt=rs.getString(7);
			String xaxis=rs.getString(8);
			String yaxis=rs.getString(9);
			String pw=rs.getString(10);
			
			dto = new SignUp(email, name, nickname, birthdate, telno, address, addressdt, xaxis, yaxis, pw);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps !=null) ps.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
	public UserDto ImportUserData(String email) {
		UserDto dto = null;
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn= dataSource.getConnection();
			String A = "select userseq, nickname, xaxis, yaxis from userdata where email= ?";
			ps=conn.prepareStatement(A);
			ps.setString(1, email);
			rs=ps.executeQuery();
			
			rs.next();
			
			int userseq = rs.getInt(1);
			String nickname = rs.getString(2);
			String xaxis = rs.getString(3);
			String yaxis = rs.getString(4);
			
			dto = new UserDto(userseq,nickname,xaxis,yaxis);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps !=null) ps.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
    public LogInDto Validation(int validation, String email, String password) 
    {
    	LogInDto dto = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
 
        String dbPW = "";
        
        int x = validation;
 
        try {
        	connection = dataSource.getConnection();
        	String query = "select pw from userdata where email = '" + email + "'";     
            pstmt = connection.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs.next())
            {
                dbPW = rs.getString("pw");
                if (dbPW.equals(password)&&email.equals("admin@billil.com")) 
                	x = 2;
                else if(dbPW.equals(password)) 
                    x = 1;
                else                  
                    x = -1;
            } else {
                x = 0;
            }
            dto = new LogInDto(x,email);
            return dto;
            
 
        } catch (Exception sqle) {
            throw new RuntimeException(sqle.getMessage());
        } finally {
            try{
                if ( pstmt != null ){ pstmt.close(); pstmt=null; }
                if ( connection != null ){ connection.close(); connection=null;    }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }
    public LogInDto Validation2(int validation, String userseq, String password) 
    {
    	LogInDto dto = null;
    	Connection connection = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	String dbPW = "";
    	
    	int x = validation;
    	
    	try {
    		connection = dataSource.getConnection();
    		String query = "select pw from userdata where userseq = '" + userseq + "'";     
    		pstmt = connection.prepareStatement(query);
    		rs = pstmt.executeQuery();
    		if (rs.next())
    		{
    			dbPW = rs.getString("pw");
    			if (dbPW.equals(password)) 
    				x = 1;
    			else                  
    				x = -1;
    		} else {
    			x = 0;
    		}
    		dto = new LogInDto(x,userseq);
    		return dto;
    		
    	} catch (Exception sqle) {
    		throw new RuntimeException(sqle.getMessage());
    	} finally {
    		try{
    			if ( pstmt != null ){ pstmt.close(); pstmt=null; }
    			if ( connection != null ){ connection.close(); connection=null;    }
    		}catch(Exception e){
    			throw new RuntimeException(e.getMessage());
    		}
    	}
    }
    public LogInDto kLogin(String email) 
    {
    	LogInDto dto = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
 
        int x = -1;
 
        try {connection = dataSource.getConnection();
        	String query = "select count(*) from userdata where email = '" + email + "'";     
            pstmt = connection.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs.next())
            { x = rs.getInt("count(*)");
            }
            dto = new LogInDto(x,email);
            return dto;
 
        } catch (Exception sqle) {
            throw new RuntimeException(sqle.getMessage());
        } finally {
            try{
                if ( pstmt != null ){ pstmt.close(); pstmt=null; }
                if ( connection != null ){ connection.close(); connection=null;    }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }
    public LogInDto FindPw(String email, String name, String telno) 
    {
    	LogInDto dto = null;
    	Connection connection = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	int x = 0;
    	try {connection = dataSource.getConnection();
    		String query = "select count(*) from userdata where email= '"+email+"' and "+ " name= '"+name+"' and "+ " telno= '"+telno+"'";     
    		pstmt = connection.prepareStatement(query);
    		rs = pstmt.executeQuery();
    		if (rs.next()){x = rs.getInt("count(*)");
    		}
    		dto = new LogInDto(x,email);
    		return dto;
    	} catch (Exception sqle) {
    		throw new RuntimeException(sqle.getMessage());
    	} finally {
    		try{
    			if ( pstmt != null ){ pstmt.close(); pstmt=null; }
    			if ( connection != null ){ connection.close(); connection=null;    }
    		}catch(Exception e){
    			throw new RuntimeException(e.getMessage());
    		}
    	}
    }
    public LogInDto FindAcc(String name, String telno) 
    {
    	LogInDto dto = null;
    	Connection connection = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	int x = 0;
    	String email=null;
    	try {
    		connection = dataSource.getConnection();
    		String query = "select email from userdata where name= '"+name+"' and "+ "telno= '"+telno+"'";     
    		pstmt = connection.prepareStatement(query);
    		rs = pstmt.executeQuery();
    		if (rs.next()){email=rs.getString(1);
    		x=1;
    		}
    		dto = new LogInDto(x,email);
    		return dto;
    		
    	} catch (Exception sqle) {
    		throw new RuntimeException(sqle.getMessage());
    	} finally {
    		try{
    			if ( pstmt != null ){ pstmt.close(); pstmt=null; }
    			if ( connection != null ){ connection.close(); connection=null;    }
    		}catch(Exception e){
    			throw new RuntimeException(e.getMessage());
    		}
    	}
    }
    public void NewPw(String email, String password) 
    {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
        	connection = dataSource.getConnection();
        	String query = "update userdata set pw = '"+password+"' where email = '" + email + "'";     
            pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(connection !=null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public ArrayList<PrdDto> MyProductList(String userseq){
			
			ArrayList<PrdDto> prdDtos = new ArrayList<PrdDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "select prdseq, uploaderseq, title, price, date1, date2, info, image1, hash from product ";
				String conquery = "where uploaderseq = ?";
				preparedStatement = connection.prepareStatement(query + conquery);
				preparedStatement.setString(1, userseq);
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
					PrdDto prdDto = new PrdDto(prdseq, uploaderseq, title, price, info, date1, date2, image1, hash);
					prdDtos.add(prdDto);
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
			return prdDtos;
		}
	
	public ArrayList<BrwDto> MyBorrowList(String userseq){ 
			
			ArrayList<BrwDto> brwDtos = new ArrayList<BrwDto>(); // 선언
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "select p.prdseq, p.title, p.price, p.image1, b.date1, b.date2 "
								+ "from product as p left join borrow as b on p.prdseq = b.prdseq ";
				String conquery = "where b.userseq = ?;";
				preparedStatement = connection.prepareStatement(query + conquery);
				preparedStatement.setString(1, userseq);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					int prdseq = resultSet.getInt("prdseq");
					String title = resultSet.getString("title");
					String price = resultSet.getString("price");
					String date1 = resultSet.getString("date1");
					String date2 = resultSet.getString("date2");
					String image1 = resultSet.getString("image1");
					BrwDto brwDto = new BrwDto(prdseq, date1, date2, title, price, image1);
					brwDtos.add(brwDto);
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
			return brwDtos;
		}
	public String getImageName(File pImageFile) {
		FTPClient ftp = null;
		String result = "";
		
		try
		{
		    ftp = new FTPClient();
		    ftp.setControlEncoding("UTF-8");
		    ftp.connect("119.207.169.213");			// 접속할 ip
		    ftp.login("tj","1234");	// 접속할 아이디, 비밀번호
		    
		    ftp.setFileType(FTPClient.BINARY_FILE_TYPE);	// 파일 깨짐 방지
		   
		    // ftp 저장할 장소 (루트의 imgs 폴더)
		    ftp.changeWorkingDirectory("/");
		   
		    File file = pImageFile;
		    
		   	// 저장할 파일 선택
		    File uploadFile = file;
		    FileInputStream fis = null;
		   
		    try{
		        fis = new FileInputStream(uploadFile);
		        
		        // ftp 서버에 파일을 저장한다. (저장한 이름, 파일)
		        boolean isSuccess = ftp.storeFile(uploadFile.getName(), fis);
	            result = uploadFile.getName();
	
		        if (isSuccess){
		            System.out.println("Upload Success");
		        }
		    } catch (IOException ex) {
		        System.out.println("ERR : "+ ex.getMessage());
		    } finally {
		        if (fis != null)
		            try
		            {
		                fis.close();
		            } catch (IOException ex) {
		    	        System.out.println("ERR2 : "+ ex.getMessage());
		            }
		    }
		    ftp.logout();
		    
		} catch (SocketException e) {
		    System.out.println("Socket:" + e.getMessage());
		} catch (IOException e)	{
		    System.out.println("IO:" + e.getMessage());
		} finally {
		    if (ftp != null && ftp.isConnected()){
		        try{
		            ftp.disconnect();
		        } catch (IOException e){
	    	        System.out.println("ERR3 : "+ e.getMessage());
		        }
		    }
		}
		
		return result;
	}
	public void addItem(String userseq, String title, String price, String date1, String date2, String info, String hash, String productImage, String xaxis, String yaxis) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into product(uploaderseq, title, price, date1, date2, info, image1, hash, xaxis, yaxis, insertdate) values(?,?,?,?,?,?,?,?,?,?, now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userseq);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, price);
			preparedStatement.setString(4, date1);
			preparedStatement.setString(5, date2);
			preparedStatement.setString(6, info);
			preparedStatement.setString(7, productImage);
			preparedStatement.setString(8, hash);
			preparedStatement.setString(9, xaxis);
			preparedStatement.setString(10, yaxis);
			preparedStatement.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<LikeDTO> MyLikeList(String userseq){ 
		
		ArrayList<LikeDTO> likeDtos = new ArrayList<LikeDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select p.prdseq, p.title, p.price, p.image1, p.date1, p.date2, p.view from product as p left join interaction as i on p.prdseq = i.prdseq ";
			String conquery = "where i.userseq = ? order by lastaction desc;";
			preparedStatement = connection.prepareStatement(query + conquery);
			preparedStatement.setString(1, userseq);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int prdseq = resultSet.getInt("prdseq");
				String title = resultSet.getString("title");
				String price = resultSet.getString("price");
				String image1 = resultSet.getString("image1");
				String date1 = resultSet.getString("date1");
				String date2 = resultSet.getString("date2");
				int view = resultSet.getInt("view");
				
				LikeDTO likeDto = new LikeDTO(prdseq, title, price, image1, date1, date2, view);
				likeDtos.add(likeDto);
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
		return likeDtos;
	}
}
