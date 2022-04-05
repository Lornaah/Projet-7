package com.nnk.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nnk.springboot.repositories.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("log")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("log");
		return mav;
	}

	@GetMapping("secure/article-details")
	public ModelAndView getAllUserArticles() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("users", userRepository.findAll());
		mav.setViewName("user/list");
		return mav;
	}

	@GetMapping("error")
	public ModelAndView error() {
		ModelAndView mav = new ModelAndView();
		String errorMessage = "You are not authorized for the requested data.";
		mav.addObject("errorMsg", errorMessage);
		mav.setViewName("403");
		return mav;
	}

	@GetMapping("login/oauth2/code/github")
	public ModelAndView logWithGitHub() {
		ModelAndView mav = new ModelAndView();
		System.err.println("Coucou GITHUB");
		mav.setViewName("bidList/list");
		return mav;

	}
}
