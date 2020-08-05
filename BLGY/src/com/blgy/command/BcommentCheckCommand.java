package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao2;
import com.blgy.dto.CmtDto;

public class BcommentCheckCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int cmtseq = Integer.parseInt(request.getParameter("cmtseq"));
		
		Dao2 dao2 = new Dao2();
		
		CmtDto dtos = dao2.cmtCheck(cmtseq);
		
		request.setAttribute("cmtCheck", dtos);

	}

}
