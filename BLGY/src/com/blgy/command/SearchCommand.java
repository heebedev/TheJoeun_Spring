package com.blgy.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blgy.dao.SearchDAO;
import com.blgy.dto.SearchDTO;

public class SearchCommand implements SCommand {

	@Override
	public void execte(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
				HttpSession session = request.getSession();
				String keyword = request.getParameter("search");
				String date1 = request.getParameter("date1");
				String date2 = request.getParameter("date2");
				String select = request.getParameter("selectsearch");
				if(date1.length()<5) {
					date1 = "2100-12-12";
				}if(date2.length()<5) {
					date2 = "1945-08-15";
				}			
				int userseq = -1;
				
				if(request.getParameter("userseq")==null) {
					
				}
				else {
					userseq = Integer.parseInt(request.getParameter("userseq"));
				}
				SearchDAO searchDAO = new SearchDAO();
				ArrayList<SearchDTO> searchdtos = searchDAO.SearchList(keyword, date1, date2, userseq, select);
				request.setAttribute("SearchList", searchdtos);
				request.setAttribute("search", keyword);
				request.setAttribute("userseq", userseq);

				
				
				
	}

}
