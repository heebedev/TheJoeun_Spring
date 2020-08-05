package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;
import com.blgy.dto.LogInDto;

public class KLoginCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String email = (request.getParameter("email"));
		Dao dao =new Dao();
		LogInDto dto =dao.kLogin(email);
		request.setAttribute("validation", dto);
	}

}
