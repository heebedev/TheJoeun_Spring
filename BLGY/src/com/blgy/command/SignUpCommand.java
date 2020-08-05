package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;

public class SignUpCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String nickname=request.getParameter("nickname");
		String telno=request.getParameter("telno");
		String address=request.getParameter("address");
		String addressdt=request.getParameter("addressdt");
		String xaxis=request.getParameter("entX");
		String yaxis=request.getParameter("entY");
		String pw=request.getParameter("pw1");

		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		
		String birthdate= year+"-"+month+"-"+day;
		
		Dao dao = new Dao();
		dao.write(email, name, nickname, birthdate, telno, address, addressdt, xaxis, yaxis, pw);
	}

}
