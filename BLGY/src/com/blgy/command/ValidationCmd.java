package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;
import com.blgy.dto.LogInDto;

public class ValidationCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int validation = -1;
		String email = (request.getParameter("email"));
		String password = (request.getParameter("pwd"));
		Dao dao =new Dao();
		LogInDto dto =dao.Validation(validation,email,password);
		request.setAttribute("validation", dto);
	}

}
