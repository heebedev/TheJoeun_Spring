package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.ADao;
import com.blgy.dto.AUserDto;
import com.blgy.dto.UserDto;

public class AdminUserModifyGetInfoCommand implements BCommand {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String getUserseq = request.getParameter("userseq");
		System.out.println(getUserseq);
		ADao adao = new ADao();
		
		//클릭한 회원 정보불러오기
		AUserDto auserdto = adao.AdminViewUserInfo(getUserseq);
		
		request.setAttribute("AdminUserUpdate", auserdto);
		
		
	}
	
	
	
}
