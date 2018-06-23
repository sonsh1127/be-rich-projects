package kr.co.circlenine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/common")
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginForm() {
		System.out.println("로그인 요청");
		return "redirect:questionForm";
	}
	
	@RequestMapping(value = "/questionForm", method = RequestMethod.GET)
	public String login() {
		logger.info("question view call");
		return "question";
	}
	
	@RequestMapping(value = "/test")
	public String test() {
		return "question";
	}
	
	
}
