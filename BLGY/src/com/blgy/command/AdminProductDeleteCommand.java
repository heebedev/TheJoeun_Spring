package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.ADao;

public class AdminProductDeleteCommand implements BCommand {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
String prdseq = request.getParameter("prdseq");
		
		ADao adao = new ADao();
		adao.AdminProductDelete(prdseq);
		
	}

}
