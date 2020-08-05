package com.blgy.command;

import java.io.File;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blgy.dao.Dao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BAddProductCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String savePath = request.getRealPath("");
		
		int sizeLimit = 10 * 1024 * 1024;
		
		MultipartRequest multi = null;
		
		
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String userseq = multi.getParameter("userseq");
		String xaxis = multi.getParameter("xaxis");
		String yaxis = multi.getParameter("yaxis");
		String title =multi.getParameter("title"); 
		String price = multi.getParameter("price");
		String date1 = multi.getParameter("date1");
		String date2 = multi.getParameter("date2");
		String info = multi.getParameter("info");
		String hash = multi.getParameter("hash");
		File pImageFile = multi.getFile("productImage");
		
		String pImage = null;
		
		Dao dao = new Dao();
		
		pImage = dao.getImageName(pImageFile);
	
		dao.addItem(userseq, title, price, date1, date2, info, hash, pImage, xaxis, yaxis);
		
		
	}

}
