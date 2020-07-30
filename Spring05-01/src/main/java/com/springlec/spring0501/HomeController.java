package com.springlec.spring0501;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping("/board/confirmid")
	public String conformId(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		
		
		return "board/confirmid";
	}
	
	@RequestMapping("/board/checkid")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		
		
		
		return "board/checkid";
	}
	
	
	@RequestMapping("/member/join")
	public String join(HttpServletRequest request, Model model) {
		
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		
//		model.addAttribute("name", name);
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);
//		model.addAttribute("email", email);
		
		
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("member", member);
		
		return "member/join";
	}
	
	
	@RequestMapping("/member/join2")
	public String join2(Member member) {
		return "member/join";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} //HomeController
