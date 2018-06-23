package kr.co.circlenine.dao;

import java.util.List;
import java.util.Map;

public interface MemberDao {
	public Map<String, Object> selectOneById(String memberId);
	public Map<String, Object> selectOneByNum(int memberNum);
	public List<String> selectMemberAuthorities(String memberId);
	
}
