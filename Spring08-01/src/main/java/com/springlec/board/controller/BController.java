package com.springlec.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.board.command.BCommand;
import com.springlec.board.command.BDeleteCommand;
import com.springlec.board.command.BInsertCommand;
import com.springlec.board.command.BListCommand;
import com.springlec.board.command.BReadCommand;
import com.springlec.board.command.BUpdateCommand;

@Controller
public class BController {
	
	BCommand command = null;
	
	@RequestMapping("/list") 
	public String list(Model model) {
		
		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);
		
		
		
		return "list";
		
	}
	
	@RequestMapping("/read")
	public String read(HttpServletRequest request, Model model) {
		System.out.println("read()");
		model.addAttribute("request", request);
		command = new BReadCommand();
		command.execute(model);
		
		return "read";
	
	}
	
	@RequestMapping("/write")
	public String write() {
		return "write";
	}
	
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request, Model model) {
		
		System.out.println("insert()");
		model.addAttribute("request", request);
		command = new BInsertCommand();
		command.execute(model);
		
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		System.out.println("update()");
		model.addAttribute("request", request);
		command = new BUpdateCommand();
		command.execute(model);
		
		return "redirect:list";
	
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		System.out.println("delete()");
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		
		return "redirect:list";
	}
	
		
		
		


		
}
