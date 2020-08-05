package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.LikeDAO;
import com.blgy.dao.ViewDAO;
import com.blgy.dto.SearchDTO;

public class ViewCommand implements SCommand {

	@Override
	public void execte(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			int userseq = Integer.parseInt(request.getParameter("userseq"));
			int prdseq = Integer.parseInt(request.getParameter("prdseq"));
			ViewDAO viewDAO = new ViewDAO();
			viewDAO.updateView(prdseq);
			request.setAttribute("userseq", userseq);
			request.setAttribute("prdseq", prdseq);
			
					
	}

}
