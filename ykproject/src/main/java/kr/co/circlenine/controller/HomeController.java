package kr.co.circlenine.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		System.out.println("11111111111");
//		return "loginForm";
		return "redirect:common/question";
	}
	
//	@RequestMapping(value="/question",method=RequestMethod.GET)
//	public String question() {
//		logger.info("question view call");
//		
//		return "question";
//	}
}
