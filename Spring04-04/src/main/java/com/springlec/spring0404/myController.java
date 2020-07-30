package com.springlec.spring0404;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class myController {

	@RequestMapping("/test/view2")
	public String view2(Model model) {
		model.addAttribute("id", "tester");
		
		return "test/viewid";
	}
	
}
