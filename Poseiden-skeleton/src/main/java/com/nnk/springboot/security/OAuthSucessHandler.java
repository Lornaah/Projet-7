package com.nnk.springboot.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.nnk.springboot.dto.UserDTO;
import com.nnk.springboot.model.AuthenticationProvider;
import com.nnk.springboot.model.UserOAuth2;
import com.nnk.springboot.services.user.UserService;

public class OAuthSucessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private RedirectStrategy redirect = new DefaultRedirectStrategy();

	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		UserOAuth2 user = (UserOAuth2) authentication.getPrincipal();

		if (!userService.userMatchesUserName(user.getId())) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(user.getId());
			userDTO.setFullname(user.getName());
			userDTO.setAuthenticationProvider(AuthenticationProvider.GITHUB);
			userDTO.setPassword("GithubProvider");
			userDTO.setRole("USER");
			userService.createUser(userDTO);
		}

		redirect.sendRedirect(request, response, "/bidList/list");
	}

}
