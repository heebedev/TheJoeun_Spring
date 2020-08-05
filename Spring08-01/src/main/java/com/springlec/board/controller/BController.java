package com.springlec.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.board.command.BDeleteCommand;
import com.springlec.board.command.BCommand;
import com.springlec.board.command.BContentCommand;
import com.springlec.board.command.BListCommand;
import com.springlec.board.command.BModifyCommand;
import com.springlec.board.command.BWriteCommand;

@Controller
public class BController {

	BCommand command = null;
	
	private BCommand listCommand = null;
	private BCommand writeCommand = null;
	private BCommand contentCommand = null;
	private BCommand modifyCommand = null;
	private BCommand deleteCommand = null;
	
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
		listCommand.execute(model);
		
		return "list";
	}
	
//	@RequestMapping("/list")
//	public String list(Model model){
//		System.out.println("list()");
//		command = new BListCommand();
//		command.execute(model);
//		
//		return "list";
//	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		writeCommand.execute(model);
		
		return "redirect:list";
	}
	
	
//	@RequestMapping("/write")
//	public String write(HttpServletRequest request, Model model) {
//		System.out.println("write()");
//		
//		model.addAttribute("request", request);
//		command = new BWriteCommand();
//		command.execute(model);
//		
//		return "redirect:list";
//	}
	
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		contentCommand.execute(model);
		
		return "content_view";
	}
	
	
//	@RequestMapping("/content_view")
//	public String content_view(HttpServletRequest request, Model model){
//		System.out.println("content_view()");
//		
//		model.addAttribute("request", request);
//		command = new BContentCommand();
//		command.execute(model);
//		
//		return "content_view";
//	}
	
	
	@RequestMapping(value="/modify")
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		modifyCommand.execute(model);
		
		return "redirect:list";
	}
	
	
//	@RequestMapping(value="/modify")
//	public String modify(HttpServletRequest request, Model model){
//		System.out.println("modify()");
//		
//		model.addAttribute("request", request);
//		command = new BModifyCommand();
//		command.execute(model);
//		
//		return "redirect:list";
//	}
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		deleteCommand.execute(model);
		
		return "redirect:list";
	}
	
	
//	@RequestMapping("/delete")
//	public String delete(HttpServletRequest request, Model model) {
//		System.out.println("delete()");
//		
//		model.addAttribute("request", request);
//		command = new BDeleteCommand();
//		command.execute(model);
//		
//		return "redirect:list";
//	}
	
	
	
	
	
	
	
	
	
	
	
} // ------
