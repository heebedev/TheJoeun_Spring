package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao2;

public class BborrowCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		int prdseq = Integer.parseInt(request.getParameter("brprdseq"));
		int userseq = Integer.parseInt(request.getParameter("userseq"));
		String sDate = request.getParameter("sdate");
		String eDate = request.getParameter("edate");
		
		
		Dao2 dao = new Dao2();
		
		
		
		dao.borrowAct(prdseq, userseq, sDate, eDate);
		
		request.setAttribute("prdseq", prdseq);
		
		
	}

}