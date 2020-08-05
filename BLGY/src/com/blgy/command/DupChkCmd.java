package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;
import com.blgy.dto.LogInDto;

public class DupChkCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		Dao dao =new Dao();
		LogInDto dto =dao.kLogin(email);
		request.setAttribute("dup", dto);
	
	}

}
