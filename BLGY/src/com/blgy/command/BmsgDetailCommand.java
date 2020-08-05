package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao2;
import com.blgy.dto.TextDto;


public class BmsgDetailCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int textseq = Integer.parseInt(request.getParameter("textseq"));
		
		Dao2 dao = new Dao2();
		
		TextDto dtos = dao.msgDetail(textseq);
		
		request.setAttribute("msgDetail", dtos);

	}

}
