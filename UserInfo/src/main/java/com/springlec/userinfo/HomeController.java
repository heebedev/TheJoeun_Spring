package com.springlec.userinfo;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
	
	
	
	@RequestMapping("/userinfo")
	public String userinfo() {
		return "userinfo";
	}
	
	
	@RequestMapping("/inforesult")
	public String inforesult(HttpServletRequest request, Model model) {
		
		
		Result result = new Result();
		
		result.setName(request.getParameter("name"));
		result.setId(request.getParameter("id"));
		result.setPw(request.getParameter("pw"));
		result.setHobby(request.getParameterValues("hobby"));
		result.setMajor(request.getParameter("major"));
		result.setProtocol(request.getParameter("protocol"));
		
		System.out.println(result.getHobby());
		
		
		model.addAttribute(result);
		
		
		return "result";
	}
	
}
