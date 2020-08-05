package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao2;

public class BcommentRUDCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		int cmtseq = Integer.parseInt(request.getParameter("cmtseq"));
		int cmtIntstate = Integer.parseInt(request.getParameter("cmtIntstate"));
		
		String comment = "";
		int prdseq = -1;
		int userseq = -1;
		
		String cmtstate;
		
		
			if (cmtIntstate == 0) {
				userseq = Integer.parseInt(request.getParameter("userseq"));
				prdseq = Integer.parseInt(request.getParameter("prdseq"));
				comment = request.getParameter("comment");
				cmtstate = "수정";
				

			} else {
				cmtstate = "삭제";
				
			}
	
		Dao2 dao = new Dao2();
		
		dao.commentRUD(cmtseq, userseq, prdseq, comment);
		
		request.setAttribute("cmtstate", cmtstate);
		
		
	}

}
