package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao2;

public class BprdRUDCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int prdseq = Integer.parseInt(request.getParameter("prdseq"));
		//System.out.println( "여기서 오나????" + prdseq);
		System.out.println(prdseq);
		String title = request.getParameter("title");
		System.out.println(title);


		Dao2 dao = new Dao2();
		
			if (title != null) {
				String price = request.getParameter("price");
				String date1 = request.getParameter("date1");
				String date2 = request.getParameter("date2");
				String hash = request.getParameter("hash");
				String info = request.getParameter("info");
				dao.prdRU(prdseq, title, price, date1, date2, hash, info);
				
				request.setAttribute("prdseq", prdseq);

			} else {
				//System.out.println("삭제");
				//System.out.println("여기");
				dao.prdDel(prdseq); 
			}
		
		//System.out.println(rentSeq);OK
		
		

	}

}
