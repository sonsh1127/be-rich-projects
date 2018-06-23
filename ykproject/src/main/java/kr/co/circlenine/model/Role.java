package kr.co.circlenine.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 8959483002960520613L;
	private String authority;
	
	public Role() {
		
	}
	
	public Role(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

	@Override
	public String toString() {
		return "Role [authority=" + authority + "]";
	}
}
