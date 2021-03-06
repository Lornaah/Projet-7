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

import com.nnk.springboot.dto.BidListDTO;
import com.nnk.springboot.services.bid.BidListService;
import com.nnk.springboot.services.user.UserService;

@Controller
public class BidListController {

	@Autowired
	BidListService bidListService;
	@Autowired
	UserService userService;

	@RequestMapping("/bidList/list")
	public String home(Model model) {
		model.addAttribute("bidList", bidListService.findAllBids());
		userService.getRole().ifPresent(a -> {
			model.addAttribute("role", a.getAuthority());
		});
		return "bidList/list";
	}

	@GetMapping("/bidList/add")
	public String addBidForm(BidListDTO bidListDTO) {
		return "bidList/add";
	}

	@PostMapping("/bidList/validate")
	public String validate(@Valid BidListDTO bidListDTO, BindingResult result, Model model) {
		if (result.hasErrors())
			return "bidList/add";
		model.addAttribute("bidList", bidListService.createBid(bidListDTO));
		return "redirect:/bidList/list";
	}

	@GetMapping("/bidList/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		BidListDTO bidList = bidListService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid update Id : " + id));
		model.addAttribute("bidList", bidList);
		return "bidList/update";
	}

	@PostMapping("/bidList/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid BidListDTO bidList, BindingResult result,
			Model model) {
		if (result.hasErrors())
			return "bidList/update";
		bidListService.updateBid(bidList);
		model.addAttribute("bidList", bidListService.findAllBids());
		return "redirect:/bidList/list";
	}

	@GetMapping("/bidList/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {
		BidListDTO bidList = bidListService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Ivalid update Id : " + id));
		bidListService.deleteBid(bidList);
		model.addAttribute("bidList", bidListService.findAllBids());
		return "redirect:/bidList/list";
	}
}
