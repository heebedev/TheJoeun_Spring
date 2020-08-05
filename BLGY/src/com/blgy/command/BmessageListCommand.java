package com.blgy.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao2;
import com.blgy.dto.TextDto;



public class BmessageListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		Dao2 dao = new Dao2();   //하자마자 데이터 연결됐다.
		
		int myseq = Integer.parseInt(request.getParameter("myseq"));
		String selection = request.getParameter("selection");
		String search = request.getParameter("search");
		String searchText = request.getParameter("searchText");
		
		//System.out.println(selection + "," + search + "," + searchText);
		ArrayList<TextDto> dtos = dao.messageList(myseq, selection, search, searchText);
		
		request.setAttribute("messageList", dtos);
		
		//리퀘스트에 dtos 어레이리스트를 묶어서 보낸다.
		
		
		
	}

}
