package com.springlec.board.command;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.board.dao.BDao;
import com.springlec.board.dto.BDto;

public class BListCommand implements BCommand {
	
	private BDao dao = null;
	
	@Autowired
	public void setDao(BDao dao) {
		this.dao = dao;
	}

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}

}
