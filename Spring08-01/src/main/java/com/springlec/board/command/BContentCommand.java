package com.springlec.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.board.dao.BDao;
import com.springlec.board.dto.BDto;

public class BContentCommand implements BCommand {
	
	
	private BDao dao = null;
	
	@Autowired
	public void setDao(BDao dao) {
		this.dao = dao;
	}

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		BDto dto = dao.contentView(bId);
		
		model.addAttribute("content_view", dto);
		
	}

}
