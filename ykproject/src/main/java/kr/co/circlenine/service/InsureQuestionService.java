package kr.co.circlenine.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.circlenine.dao.InsureQuestionDao;



@Service
public class InsureQuestionService {
	
	@Autowired
	InsureQuestionDao questionDao;
	public boolean enrollInsureQuestion(Map<String, Object> question) {
		
		
		String insureCode = (String)question.get("diseaseCategory1")
				+(String)question.get("diseaseCategory2")
				+(String)question.get("diseaseCategory3")
				+(String)question.get("diseaseCategory4");
		
		question.put("insureCode", insureCode);
		int result = questionDao.insertQuestion(question);
		
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
}
