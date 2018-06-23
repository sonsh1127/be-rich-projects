package kr.co.circlenine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.circlenine.controller.InsuranceController;
import kr.co.circlenine.dao.InsuranceDao;

@Service
public class InsuranceService {
	@Autowired
	InsuranceDao insuranceDao;
	
	public List<String> getInsuranceKinds() {
		List<Map<String, Object>> insuranceKinds = insuranceDao.selectAll();
		
		List<String> insureList = new ArrayList<String>();
		
		for(Map m : insuranceKinds) {
			insureList.add((String)m.get("insure_name")); 
		}
		System.out.println("insureList : " + insureList);
		
		return insureList;
	}
	
}
