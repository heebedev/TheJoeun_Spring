package com.springlec.spring0601;

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
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/student")
//	public String student(HttpServletRequest request, Model model) {
//		
//		System.out.println("RequestMethod.GET");
//		
//		String id = request.getParameter("id");
//		System.out.println("ID" + id);
//		
//		model.addAttribute("studentId", id);
//		
//		
//		return "student/studentId";
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, value = "/student")
//	public String student1(HttpServletRequest request, Model model) {
//		
//		System.out.println("RequestMethod.POST");
//		
//		String id = request.getParameter("id");
//		System.out.println("ID" + id);
//		
//		model.addAttribute("studentId", id);
//		
//		
//		return "student/studentId";
//	}
	
	
	//version4 이상에서는 똑같은 이름이 아닌 이상 GET/POST 구분하지 않고 쓸 수 있다. 
	@RequestMapping("/student")
	public String student1(HttpServletRequest request, Model model) {
		
		//System.out.println("RequestMethod.POST");
		
		String id = request.getParameter("id");
		System.out.println("ID" + id);
		
		model.addAttribute("studentId", id);
		
		
		return "student/studentId";
	}
	
}
