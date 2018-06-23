package kr.co.circlenine.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import kr.co.circlenine.model.Member;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	@Qualifier("customUserDetailService")
	private UserDetailsService userDetailService;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//유저가 입력한 정보를 이이디비번으으로만든다.(로그인한 유저아이디비번정보를담는다)
		
		System.out.println("CustomAuthenticationProvider 진입!!" );
		
		
		UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
		String memberId = authentication.getName();
		String password =(String)authentication.getCredentials();
		System.out.println("id : " + memberId);
		System.out.println("pssword : " + password);
		Member member = (Member)userDetailService.loadUserByUsername(memberId) ;
		System.out.println("authToken : " + authToken);
		if(member == null) {
			throw new UsernameNotFoundException(authToken.getName());
		}
		
		if(!passwordEncoder.matches(password, member.getPassword())) {
			throw new BadCredentialsException("not matching username or password");
		}else {
			
//			Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

//			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			List<? extends GrantedAuthority> authorities = (List<GrantedAuthority>) member.getAuthorities();
			System.out.println("authorities : " + authorities);
			authToken = new UsernamePasswordAuthenticationToken(member,null, authorities);
			System.out.println("authToken22222 : " + authToken);
			return authToken;
		}
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
}
