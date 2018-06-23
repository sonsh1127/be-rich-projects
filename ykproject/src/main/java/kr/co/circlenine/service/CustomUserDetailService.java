package kr.co.circlenine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.circlenine.dao.MemberDao;
import kr.co.circlenine.model.Member;
import kr.co.circlenine.model.Role;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public Member loadUserByUsername(String memberId) throws UsernameNotFoundException {
		
		System.out.println("CustomUserDetailService  진입!!");
		
		Map<String, Object> dbMember = memberDao.selectOneById(memberId);
		
		if(dbMember == null) {
			return null;
		}
		
		Member member = new Member(dbMember);
		//authorities 가서 해당 멤버 아이디 가져오기
		
		//멤버 권한 리스트 가져오기
		List<String> strAuthorities = memberDao.selectMemberAuthorities(memberId);
//		System.out.println("member authorities : " + strAuthorities);
		List<Role> roleAuthorities = new ArrayList<Role>();
		
		for(String authority : strAuthorities) {
			roleAuthorities.add(new Role(authority));
		}
		member.setAuthorities(roleAuthorities);
		
		return member;
	}	
}
