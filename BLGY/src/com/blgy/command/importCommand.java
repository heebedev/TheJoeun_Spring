package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;
import com.blgy.dto.UserDto;

public class importCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String email = (request.getParameter("email"));
		Dao dao =new Dao();
		UserDto dto =dao.ImportUserData(email);
		request.setAttribute("userData", dto);

	}

}
