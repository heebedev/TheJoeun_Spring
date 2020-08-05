package com.blgy.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;
import com.blgy.dto.PrdDto;


public class BMyProductListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userseq = request.getParameter("userseq");
		Dao dao = new Dao();
		ArrayList<PrdDto> prdDtos = dao.MyProductList(userseq);
		request.setAttribute("MyProductList", prdDtos); 
	}
}
