package com.springlec.mybatisAddressEx;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springlec.mybatisAddressEx.dao.ADao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired 
	private SqlSession sqlSession;
	
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
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		ADao dao = sqlSession.getMapper(ADao.class); // 컨트롤러는  xml을 모르기때문에 IDao.java를 만들었다.
		model.addAttribute("list", dao.addressDao());
		
		return "list";
	}
	
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return ("writeForm");
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		ADao dao = sqlSession.getMapper(ADao.class);
		dao.writeDao(request.getParameter("name"), request.getParameter("telno"), request.getParameter("address"), request.getParameter("email"), request.getParameter("relation"));
		return "redirect:list";
	}
	
	@RequestMapping("/updateform")
	public String updateForm(HttpServletRequest request, Model model) {
		ADao dao = sqlSession.getMapper(ADao.class); // 컨트롤러는  xml을 모르기때문에 IDao.java를 만들었다.
		model.addAttribute("detail", dao.detailDao(Integer.parseInt(request.getParameter("seq"))));
		
		return ("updateForm");
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		ADao dao = sqlSession.getMapper(ADao.class);
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String name = request.getParameter("name");
		String telno = request.getParameter("telno");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String relation = request.getParameter("relation");
		dao.updateDao(seq, name, telno , address , email , relation);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		ADao dao = sqlSession.getMapper(ADao.class);
		dao.deleteDao(Integer.parseInt(request.getParameter("seq")));
		return "redirect:list";
	}
	
	@RequestMapping("/listQuery")
	public String listQuery(HttpServletRequest request, Model model) {
		ADao dao = sqlSession.getMapper(ADao.class);
		model.addAttribute("list", dao.listQuery(request.getParameter("query"), request.getParameter("content")));
		
		
		return "list";
	}
	
}
