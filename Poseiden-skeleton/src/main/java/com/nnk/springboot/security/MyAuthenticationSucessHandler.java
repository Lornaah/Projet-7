package com.nnk.springboot.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MyAuthenticationSucessHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

	private RedirectStrategy redirect = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
			redirect.sendRedirect(request, response, "/user/list");
		} else {
			redirect.sendRedirect(request, response, "/bidList/list");
		}
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		redirect.sendRedirect(request, response, "/403");
	}

}
