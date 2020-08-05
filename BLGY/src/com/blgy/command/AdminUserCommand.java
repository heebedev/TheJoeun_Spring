package com.blgy.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.ADao;
import com.blgy.dto.AUserDto;

public class AdminUserCommand implements BCommand {

	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		/// ADao 사용 //////
				ADao adao = new ADao();
				ArrayList<AUserDto> aUserDtos = ADao.AUserList();
				request.setAttribute("AdminUserList", aUserDtos);
				
		
	}

}
