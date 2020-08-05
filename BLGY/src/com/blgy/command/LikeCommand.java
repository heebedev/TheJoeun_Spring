  package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blgy.dao.LikeDAO;
import com.mysql.cj.Session;

public class LikeCommand implements SCommand {

	@Override
	public void execte(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int prdseq = Integer.parseInt(request.getParameter("prdseq"));
		int userseq = Integer.parseInt(request.getParameter("userseq"));
		String liked2 = request.getParameter("liked2");
		String search = request.getParameter("search");
		if(userseq == 0 || userseq == -1) {
			
		}else {
		LikeDAO likeDAO = new LikeDAO();
		likeDAO.likeInsert(userseq, prdseq, liked2);
		}
		request.setAttribute("search", search); 
		request.setAttribute("userseq", userseq); 
		
		
	}

}
