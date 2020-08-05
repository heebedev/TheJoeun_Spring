package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao2;
import com.blgy.dto.UserDto;


public class BmessageCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String message = request.getParameter("message");
		String nickname = request.getParameter("nickname");
		
		Dao2 dao = new Dao2();
		
		UserDto dto = dao.usInfo(nickname);
		
		int userseq = dto.getUserseq();
		int myseq = Integer.parseInt(request.getParameter("myseq"));
		
		//System.out.println(myseq);
		dao.SendMessage(myseq, userseq, message);
	
		
	}

}