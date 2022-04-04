package com.nnk.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.dto.RatingDTO;
import com.nnk.springboot.services.rating.RatingService;
import com.nnk.springboot.services.user.UserService;

@Controller
public class RatingController {

	@Autowired
	RatingService ratingService;
	@Autowired
	UserService userService;

	@RequestMapping("/rating/list")
	public String home(Model model) {
		model.addAttribute("rating", ratingService.findAllRatings());

		userService.getRole().ifPresent(a -> {
			model.addAttribute("role", a.getAuthority());
		});
		return "rating/list";
	}

	@GetMapping("/rating/add")
	public String addRatingForm(RatingDTO ratingDTO) {
		return "rating/add";
	}

	@PostMapping("/rating/validate")
	public String validate(@Valid RatingDTO ratingDTO, BindingResult result, Model model) {
		if (result.hasErrors())
			return "rating/add";

		model.addAttribute("rating", ratingService.createRating(ratingDTO));
		return "redirect:/rating/list";
	}

	@GetMapping("/rating/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		RatingDTO rating = ratingService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid update Id : " + id));
		model.addAttribute("rating", rating);
		return "rating/update";
	}

	@PostMapping("/rating/update/{id}")
	public String updateRating(@PathVariable("id") Integer id, @Valid RatingDTO ratingDTO, BindingResult result,
			Model model) {
		if (result.hasErrors())
			return "rating/update";
		ratingService.updateRating(ratingDTO);
		model.addAttribute("rating", ratingService.findAllRatings());
		return "redirect:/rating/list";
	}

	@GetMapping("/rating/delete/{id}")
	public String deleteRating(@PathVariable("id") Integer id, Model model) {
		RatingDTO rating = ratingService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid update Id : " + id));
		ratingService.deleteRating(rating);
		model.addAttribute("rating", ratingService.findAllRatings());
		return "redirect:/rating/list";
	}
}
