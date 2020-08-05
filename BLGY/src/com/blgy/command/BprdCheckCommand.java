package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao2;
import com.blgy.dto.PrdDto;

public class BprdCheckCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		int prdseq = Integer.parseInt(request.getParameter("prdseq"));
		
		Dao2 dao = new Dao2();
		
		PrdDto dtos = dao.pdDetail(prdseq, -1);
		
		request.setAttribute("pdDetail", dtos);
		
	}

}
