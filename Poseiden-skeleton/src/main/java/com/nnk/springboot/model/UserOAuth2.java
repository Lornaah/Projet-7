package com.nnk.springboot.model;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class UserOAuth2 implements OAuth2User {

	private OAuth2User oAuth2User;

	public UserOAuth2(OAuth2User oAuth2User) {
		this.oAuth2User = oAuth2User;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return oAuth2User.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return oAuth2User.getAuthorities();
	}

	@Override
	public String getName() {
		return oAuth2User.getAttribute("name");
	}

	public String getLogin() {
		return oAuth2User.getAttribute("login");
	}

	public String getId() {
		return oAuth2User.getAttribute("id").toString();
	}
}
