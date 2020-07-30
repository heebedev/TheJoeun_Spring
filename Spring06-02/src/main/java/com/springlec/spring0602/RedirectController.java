package com.springlec.spring0602;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	
	@RequestMapping("/studentConfirm")
	public String student(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		
		if(id.equals("abc")) {
			return "redirect:studentOk";
		} else {
			return "redirect:studentNg";
		}
		
		
	}
	
	@RequestMapping("studentOk")
	public String studentOk() {
		
		return "student/studentOk";
	}
	
	@RequestMapping("studentNg")
	public String studentNg() {
		
		return "student/studentNg";
	}
	

}
