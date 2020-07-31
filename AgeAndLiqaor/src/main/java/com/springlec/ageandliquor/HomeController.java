package com.springlec.ageandliquor;

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
	
	
	@RequestMapping("/keyinage")
	public String keyinage() {
		return ("keyinage");
	}
	
	
	@RequestMapping("/resultage")
	public String resultage(HttpServletRequest request, Model model) {
		
		Result result = new Result();
		String age = request.getParameter("age");
		
		result.setAge(age);
		
		if(Integer.parseInt(age) < 20) {
			result.setGroup("미성년자");
			result.setPossible("불가능");
		} else {
			result.setGroup("성인");
			result.setPossible("가능");
		}
			
		model.addAttribute(result);
		
		return ("ageresult/ageresult");
	}
	
}
