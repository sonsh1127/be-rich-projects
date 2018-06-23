package kr.co.circlenine.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityTest {
	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		
		System.out.println("123: "+ encoder.matches("1q2w3e4r",encoder.encode("1q2w3e4r")));
	}
}
