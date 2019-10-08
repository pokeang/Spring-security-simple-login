package com.simple.web.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.simple.web.dto.User;
import com.simple.web.service.api.IUserService;

public class UserAuthentication implements AuthenticationProvider, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IUserService userService;

	public UserAuthentication() {}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		User userAccount = new User();
		userAccount = this.userService.getUsernameAndPassword((String) authentication.getPrincipal(),(String) authentication.getCredentials());
		if (userAccount != null) {
			return this.dbAuthentication(authentication, userAccount);
		} else {
			throw new BadCredentialsException("Invalid username and password. Please try again.");
		}
	}

	private Authentication dbAuthentication(Authentication authentication, User userAccount) {
		List<GrantedAuthority> grantedAuthentication = new ArrayList<>();
		grantedAuthentication.add(new SimpleGrantedAuthority("ROLE_" + userAccount.getUserRole().getRole().toUpperCase()));
		Authentication authenticated = new UsernamePasswordAuthenticationToken(
				authentication.getPrincipal(), authentication.getCredentials(), grantedAuthentication);
		return authenticated;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}