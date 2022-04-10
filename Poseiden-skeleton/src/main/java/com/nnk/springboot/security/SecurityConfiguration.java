package com.nnk.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.nnk.springboot.services.oAuthUser.oAuthUserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	oAuthUserServiceImpl oAuthUserServiceImpl;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/*.css", "/image/*", "/oauth2/**", "/403").permitAll()
				.antMatchers("/user/*").hasAuthority("ADMIN").anyRequest().authenticated().and().formLogin()
				.loginPage("/log").successHandler(authenticationSucess()).failureHandler(authenticationFail())
				.permitAll().and().logout().logoutUrl("/disconnected").logoutSuccessUrl("/log").permitAll().and()
				.oauth2Login().loginPage("/log").userInfoEndpoint().userService(oAuthUserServiceImpl).and()
				.successHandler(oAuth2Success());
	}

	@Bean
	public OAuthSucessHandler oAuth2Success() {
		return new OAuthSucessHandler();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationSuccessHandler authenticationSucess() {
		return new MyAuthenticationSucessHandler();
	}

	@Bean
	public AuthenticationFailureHandler authenticationFail() {
		return new MyAuthenticationSucessHandler();
	}

}
