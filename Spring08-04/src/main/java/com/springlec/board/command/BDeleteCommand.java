package com.springlec.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.board.dao.BDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap(); // Spring 은 보안상 Model에 있는 데이터가 뒤죽박죽으로 되어있어서 Map 으로 맞춰줘야함.
		HttpServletRequest request = (HttpServletRequest)map.get("bId"); // 이렇게 가져와도 자바는 모른다. map타입을 request	타입으로 바꿔줘야함.
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		BDao dao = new BDao();
		dao.delete(bId);
		
	}

}
