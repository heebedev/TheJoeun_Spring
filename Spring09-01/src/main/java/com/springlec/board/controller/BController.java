package com.springlec.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.board.command.BDeleteCommand;
import com.springlec.board.command.BCommand;
import com.springlec.board.command.BContentCommand;
import com.springlec.board.command.BListCommand;
import com.springlec.board.command.BModifyCommand;
import com.springlec.board.command.BWriteCommand;
import com.springlec.board.util.Constant;

@Controller
public class BController {

	
	private JdbcTemplate template; //얘는 서블렛 컨텍스트에 있는거 
	
	//BCommand command = null; 안쓰고 
	////DI: Spring version 4,5 방식 이용 
	private BCommand listCommand = null;
	private BCommand writeCommand = null; //
	private BCommand contentCommand = null; //
	private BCommand modifyCommand = null; //
	private BCommand deleteCommand = null; //
	
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template; 
		Constant.template = this.template; //다음부터 Autowired 안하고 쓰는 방법 
	}
	
	////DI: Spring version 4,5 방식 이용 
	@Autowired 
	public void auto(BCommand list, BCommand write, BCommand content, BCommand modify, BCommand delete) {
		this.listCommand = list;
		this.writeCommand = write;
		this.contentCommand = content;
		this.modifyCommand = modify;
		this.deleteCommand = delete;
	}
	
	
	@RequestMapping("/list")
	public String list(Model model){
		System.out.println("list()");
		//command = new BListCommand();
		listCommand.execute(model);
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("write_view()");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		//command = new BWriteCommand();
		writeCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		//command = new BContentCommand();
		contentCommand.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value="/modify")
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		//command = new BModifyCommand();
		modifyCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		//command = new BDeleteCommand();
		deleteCommand.execute(model);
		
		return "redirect:list";
	}
	
	
	
	
	
	
	
	
	
	
	
} // ------
