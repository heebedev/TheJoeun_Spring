package com.springlec.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.board.command.BCommand;
import com.springlec.board.command.BDeleteCommand;
import com.springlec.board.command.BDetailCommand;
import com.springlec.board.command.BListCommand;
import com.springlec.board.command.BUpdateCommand;
import com.springlec.board.command.BWriteCommand;
import com.springlec.board.config.AppConfig;
import com.springlec.board.dto.BDto;

@Controller
public class BController {
	
	BCommand command = null;
	AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@RequestMapping("/list") // Session, Cookie, Model 모두 어디에 사용하든 컨드롤러에 등록이 되어있어야함.
	public String list(Model model){
		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write");
		command = ctx.getBean("list",BListCommand.class);
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Model model) {
		System.out.println("detail()");
		model.addAttribute("bId", request);
		command = new BDetailCommand();
		command.execute(model);
		
		return "detail";
	}
	
	@RequestMapping("/update_view")
	public String update_view(HttpServletRequest request, Model model) {
		System.out.println("update_view()");
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		model.addAttribute("bId", bId);
		model.addAttribute("bName", bName);
		model.addAttribute("bTitle", bTitle);
		model.addAttribute("bContent", bContent);
		
		return "update_view";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		System.out.println("update()");
		model.addAttribute("request",request);
		command = new BUpdateCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		model.addAttribute("bId",request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	

}//-------
