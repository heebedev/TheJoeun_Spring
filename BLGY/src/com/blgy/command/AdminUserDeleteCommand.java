package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.ADao;

public class AdminUserDeleteCommand implements BCommand {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String userseq = request.getParameter("userseq");
		
		ADao adao = new ADao();
		adao.AdminUserDelete(userseq);
		
		
	}

}
