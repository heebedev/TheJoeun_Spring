package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.ADao;
import com.blgy.dto.AUserDto;
import com.blgy.dto.PrdDto;

public class AdminProductModifyGetInfoCommand implements BCommand {



	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String getPrdseq = request.getParameter("prdseq");
		System.out.println(getPrdseq);
		ADao adao = new ADao();
		
		//클릭한 회원 정보불러오기
		PrdDto aprddto = adao.AdminViewPrdInfo(getPrdseq);
		
		request.setAttribute("AdminPrdUpdate", aprddto);
	}

}
