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

import com.nnk.springboot.dto.RuleNameDTO;
import com.nnk.springboot.services.ruleName.RuleNameService;

@Controller
public class RuleNameController {
	@Autowired
	RuleNameService ruleNameService;

	@RequestMapping("/ruleName/list")
	public String home(Model model) {
		model.addAttribute("ruleName", ruleNameService.findAllRuleNames());
		return "ruleName/list";
	}

	@GetMapping("/ruleName/add")
	public String addRuleForm(RuleNameDTO rule) {
		return "ruleName/add";
	}

	@PostMapping("/ruleName/validate")
	public String validate(@Valid RuleNameDTO rule, BindingResult result, Model model) {
		if (result.hasErrors())
			return "ruleName/add";
		model.addAttribute("ruleName", ruleNameService.createRule(rule));
		return "redirect:/ruleName/list";
	}

	@GetMapping("/ruleName/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		RuleNameDTO ruleName = ruleNameService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid update Id : " + id));
		model.addAttribute("ruleName", ruleName);
		return "ruleName/update";
	}

	@PostMapping("/ruleName/update/{id}")
	public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleNameDTO ruleName, BindingResult result,
			Model model) {
		if (result.hasErrors())
			return "ruleName/update";
		ruleNameService.updateRuleName(ruleName);
		model.addAttribute("ruleName", ruleNameService.findAllRuleNames());
		return "redirect:/ruleName/list";
	}

	@GetMapping("/ruleName/delete/{id}")
	public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
		RuleNameDTO ruleName = ruleNameService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid update Id : " + id));
		ruleNameService.deleteRuleName(ruleName);
		model.addAttribute("ruleName", ruleNameService.findAllRuleNames());
		return "redirect:/ruleName/list";
	}
}
