package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.ADao;

public class AdminProductModifyCommand implements BCommand {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// 수정한 데이터 가져오기 
					String prdseq = request.getParameter("prdseq");
					String uploaderseq = request.getParameter("uploaderseq");
					String newtitle = request.getParameter("newtitle");
					String newprice = request.getParameter("newprice");
					String newdate1 = request.getParameter("newdate1");
					String newdate2 = request.getParameter("newdate2");
					String newinfo = request.getParameter("newinfo");
					String newhash = request.getParameter("newhash");
					
					//이건지금안씀
					String newxaxis = request.getParameter("newxaxis");
					String newyaxis = request.getParameter("newyaxis");
					String newupdatedate = request.getParameter("newupdatedate");
					
							
					//DB에 저장 
					ADao adao = new ADao();
					adao.AdminPrdModify(prdseq, uploaderseq, newtitle, newprice, newdate1, newdate2, newinfo, newhash, newxaxis, newyaxis, newupdatedate);
					
		
	}

}
