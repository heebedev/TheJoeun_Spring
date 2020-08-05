package com.blgy.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.ADao;
import com.blgy.dto.APrdDto;
import com.blgy.dto.AUserDto;

public class AdminProductSearchCommand implements BCommand {



	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String selection = request.getParameter("selection");
		String adminProductSearchText = request.getParameter("adminProductSearchText");
		
		ADao adao = new ADao();
		
		ArrayList<APrdDto> aProductSearchDtos = adao.AProductSearchList(selection, adminProductSearchText);
		request.setAttribute("AdminProductSearchList", aProductSearchDtos);
		
	}

}
