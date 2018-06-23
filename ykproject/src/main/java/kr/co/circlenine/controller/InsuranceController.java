package kr.co.circlenine.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.circlenine.service.InsuranceService;
import kr.co.circlenine.service.InsureQuestionService;

@Controller
@RequestMapping("/insure")
public class InsuranceController {
	
	@Autowired
	InsuranceService service;
	
	@Autowired
	InsureQuestionService questionService;
	
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getInsureList() {
		System.out.println("??????요청 받았어요");
		
		List<String> list = service.getInsuranceKinds();
//		list.add("A");
//		list.add("B");
//		list.add("C");
//		list.add("D");
//		list.add("E");
//		list.add("F");
//		list.add("G");
		ResponseEntity<List<String>> entity = new ResponseEntity<List<String>>(list,HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value = "/questionEnroll", method = RequestMethod.POST) 
	public String enrollQuestion(@RequestParam Map<String,Object> params) {
		
		questionService.enrollInsureQuestion(params);
		return "result";
	}
	
}
