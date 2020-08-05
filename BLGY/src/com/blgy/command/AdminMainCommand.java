package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.ADao;

public class AdminMainCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
ADao adao = new ADao();
		
		String countTodayUser = adao.AdminMainCountUser();
		String countTodayProduct = adao.AdminMainCountProduct();
		String countTodayBorrow = adao.AdminMainCountBorrow();
		request.setAttribute("adminMainCountUser", countTodayUser);
		request.setAttribute("adminMainCountProduct", countTodayProduct);
		request.setAttribute("adminMainCountBorrow", countTodayBorrow);
		
	}

}
