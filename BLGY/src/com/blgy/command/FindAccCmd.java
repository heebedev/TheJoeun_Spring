package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;
import com.blgy.dto.LogInDto;

public class FindAccCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String telno = request.getParameter("telno");
		Dao dao =new Dao();
		LogInDto dto=dao.FindAcc(name, telno);
		request.setAttribute("acc", dto);
	}

}
