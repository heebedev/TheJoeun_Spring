package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao2;

public class BcommentAddCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int prdseq = Integer.parseInt(request.getParameter("prdseq"));
		int myseq = Integer.parseInt(request.getParameter("myseq"));
		String comment = request.getParameter("cmtTxt");
		
		Dao2 dao = new Dao2();
		
		dao.AddComment(prdseq, myseq, comment);
		
	}

}
