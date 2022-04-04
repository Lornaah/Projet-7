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

import com.nnk.springboot.dto.CurvePointDTO;
import com.nnk.springboot.services.curve.CurvePointService;
import com.nnk.springboot.services.user.UserService;

@Controller
public class CurveController {

	@Autowired
	CurvePointService curvePointService;
	@Autowired
	UserService userService;

	@RequestMapping("/curvePoint/list")
	public String home(Model model) {
		model.addAttribute("curvePoint", curvePointService.findAllCurves());
		userService.getRole().ifPresent(a -> {
			model.addAttribute("role", a.getAuthority());
		});
		return "curvePoint/list";
	}

	@GetMapping("/curvePoint/add")
	public String addBidForm(CurvePointDTO curvePointDTO) {
		return "curvePoint/add";
	}

	@PostMapping("/curvePoint/validate")
	public String validate(@Valid CurvePointDTO curvePointDTO, BindingResult result, Model model) {
		if (result.hasErrors())
			return "curvePoint/add";

		model.addAttribute("curvePoint", curvePointService.createCurve(curvePointDTO));
		return "redirect:/curvePoint/list";
	}

	@GetMapping("/curvePoint/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		CurvePointDTO curvePoint = curvePointService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid update Id : " + id));
		model.addAttribute("curvePoint", curvePoint);
		return "curvePoint/update";
	}

	@PostMapping("/curvePoint/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid CurvePointDTO curvePointDTO, BindingResult result,
			Model model) {
		if (result.hasErrors())
			return "curvePoint/update";
		curvePointService.updateCurve(curvePointDTO);
		model.addAttribute("curvePoint", curvePointService.findAllCurves());
		return "redirect:/curvePoint/list";
	}

	@GetMapping("/curvePoint/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {
		CurvePointDTO curvePoint = curvePointService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid update Id : " + id));
		curvePointService.deleteCurve(curvePoint);
		model.addAttribute("curvePoint", curvePointService.findAllCurves());
		return "redirect:/curvePoint/list";
	}
}
