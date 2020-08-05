package com.springlec.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.board.dao.BDao;
import com.springlec.board.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		BDao dao = new BDao(); // BDao 선언.
		ArrayList<BDto> dtos = dao.list(); // return 값(ArrayList) 를 넣어줌.
		model.addAttribute("list",dtos); // model에 저장.
	}

}
