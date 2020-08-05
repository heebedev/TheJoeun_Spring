package com.blgy.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.MainDAO;
import com.blgy.dto.MainDTO;
import com.blgy.dto.SearchDTO;

public class MainCommand implements SCommand {

	@Override
	public void execte(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int userseq = -1;
		if(request.getParameter("userseq")==null) {
		}else {
			userseq = Integer.parseInt(request.getParameter("userseq"));
		}
		request.setAttribute("userseq", userseq);
		MainDAO mainDAO = new MainDAO();
		ArrayList<MainDTO> maindtios = mainDAO.MainList();
		request.setAttribute("MainList", maindtios);
	}	
		
}
