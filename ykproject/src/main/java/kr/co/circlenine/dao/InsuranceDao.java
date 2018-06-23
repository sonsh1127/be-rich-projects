package kr.co.circlenine.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

public interface InsuranceDao {
	public List<Map<String, Object>> selectAll();
}
