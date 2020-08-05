package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;
import com.blgy.dto.LogInDto;

public class AuthorizeCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int validation = 0;
		String userseq = (request.getParameter("userseq"));
		String password = (request.getParameter("pw"));
		Dao dao =new Dao();
		LogInDto dto =dao.Validation2(validation,userseq,password);
		request.setAttribute("validation", dto);

	}

}
