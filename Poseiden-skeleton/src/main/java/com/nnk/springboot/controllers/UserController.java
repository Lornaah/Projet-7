package com.nnk.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.dto.UserDTO;
import com.nnk.springboot.model.User;
import com.nnk.springboot.services.user.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/list")
	public String home(Model model) {
		model.addAttribute("users", userService.findAllUsers());

		userService.getRole().ifPresent(a -> {
			model.addAttribute("role", a.getAuthority());
		});
		return "user/list";
	}

	@GetMapping("/user/add")
	public String addUser(User user) {
		return "user/add";
	}

	@PostMapping("/user/validate")
	public String validate(@Valid UserDTO userDTO, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			userDTO.setPassword(encoder.encode(userDTO.getPassword()));
			userService.createUser(userDTO);
			model.addAttribute("users", userService.findAllUsers());
			return "redirect:/user/list";
		}
		return "user/add";
	}

	@GetMapping("/user/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		UserDTO user = userService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		user.setPassword("");
		model.addAttribute("user", user);
		return "user/update";
	}

	@PostMapping("/user/update/{id}")
	public String updateUser(@PathVariable("id") Integer id, @Valid UserDTO user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user/update";
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setId(id);
		userService.updateUser(user);
		model.addAttribute("users", userService.findAllUsers());
		return "redirect:/user/list";
	}

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		UserDTO user = userService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		userService.deleteUser(user);
		model.addAttribute("users", userService.findAllUsers());
		return "redirect:/user/list";
	}
}
