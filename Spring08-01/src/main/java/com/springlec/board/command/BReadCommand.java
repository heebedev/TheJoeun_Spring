package com.springlec.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.board.dao.BDao;
import com.springlec.board.dto.BDto;

public class BReadCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		System.out.println("readCommand");
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		System.out.println(bId);
		
		BDao dao = new BDao();
		BDto dto = dao.read(bId);
		
		
		model.addAttribute("dto", dto);
		
	}

}
