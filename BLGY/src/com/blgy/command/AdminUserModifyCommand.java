package com.blgy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.ADao;

public class AdminUserModifyCommand implements BCommand {

	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// 수정한 데이터 가져오기 
					String userseq = request.getParameter("userseq");
					String newname = request.getParameter("newname");
					String newnickname = request.getParameter("newnickname");
					String newpw = request.getParameter("newpw");
					String newbirthdate = request.getParameter("newbirthdate");
					String newemail = request.getParameter("newemail");
					String newtelno = request.getParameter("newtelno");
					String newaddress = request.getParameter("newaddress");
					String newaddressdt = request.getParameter("newaddressdt");
					
					//DB에 저장 
					ADao adao = new ADao();
					adao.AdminUserModify(userseq, newname, newnickname, newpw, newbirthdate, newemail, newtelno, newaddress, newaddressdt);
					
				
		
	}

}
