package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;
import com.blgy.dto.SignUp;

public class ImportPrivacycmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userseq = (request.getParameter("userseq"));
		Dao dao =new Dao();
		SignUp dto =dao.read(userseq);
		request.setAttribute("userdata", dto);
	}

}
