package com.blgy.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;
import com.blgy.dto.LikeDTO;

public class MyLikeCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userseq = request.getParameter("userseq");
		Dao dao = new Dao();
		ArrayList<LikeDTO> likeDtos = dao.MyLikeList(userseq); 
		request.setAttribute("MyLikeList", likeDtos);
	}

}
