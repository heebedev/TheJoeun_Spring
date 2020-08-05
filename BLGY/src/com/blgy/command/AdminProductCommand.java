package com.blgy.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.ADao;
import com.blgy.dto.APrdDto;



public class AdminProductCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/// ADao 사용 //////
				ADao adao = new ADao();
				
				//APrdDto사용///
				ArrayList<APrdDto> aProductDtos = adao.AProductList();
				request.setAttribute("AdminProductList", aProductDtos);
				
				
		
	}

}
