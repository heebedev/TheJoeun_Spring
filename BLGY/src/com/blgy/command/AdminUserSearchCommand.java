package com.blgy.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.ADao;
import com.blgy.dto.AUserDto;

public class AdminUserSearchCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String selection = request.getParameter("selection");
		String adminUserSearchText = request.getParameter("adminUserSearchText");
		
		ADao adao = new ADao();
		
		ArrayList<AUserDto> aUserSearchDtos = adao.AUserSearchList(selection, adminUserSearchText);
		request.setAttribute("AdminUserSearchList", aUserSearchDtos);
		
	}

}
