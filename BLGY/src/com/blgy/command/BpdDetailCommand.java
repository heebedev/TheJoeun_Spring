package com.blgy.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao2;
import com.blgy.dto.CmtDto;
import com.blgy.dto.PrdDto;


public class BpdDetailCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int prdseq = Integer.parseInt(request.getParameter("prdseq"));
		int userseq = Integer.parseInt(request.getParameter("userseq"));
		

		
		Dao2 dao = new Dao2();
		
		PrdDto dtos = dao.pdDetail(prdseq, userseq);
		
		ArrayList<CmtDto> cmtdtos = dao.cmtDetail(prdseq, userseq);
		
		String interlike = dao.pdlike(prdseq, userseq);
		
		request.setAttribute("pdDetail", dtos);
		request.setAttribute("cmtDetail", cmtdtos);
		request.setAttribute("like", interlike);
		request.setAttribute("userseq", userseq);
		
	}
}