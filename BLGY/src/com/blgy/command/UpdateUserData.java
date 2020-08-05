package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;

public class UpdateUserData implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub		
		String email= request.getParameter("email");
		String nickname= request.getParameter("nickname");		
		String password= request.getParameter("pw");
		String telno= request.getParameter("telno");
		String address= request.getParameter("address");
		String addressdt= request.getParameter("addressdt");
		String xaxis= request.getParameter("entX");
		String yaxis= request.getParameter("entY");
		
		Dao dao = new Dao();
		dao.update(email, nickname, password, telno, address, addressdt, xaxis, yaxis);
		
	}

}
