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

import com.nnk.springboot.model.Trade;
import com.nnk.springboot.services.trade.TradeService;

@Controller
public class TradeController {
	@Autowired
	TradeService tradeService;

	@RequestMapping("/trade/list")
	public String home(Model model) {
		model.addAttribute("trade", tradeService.findAllTrades());
		return "trade/list";
	}

	@GetMapping("/trade/add")
	public String addUser(Trade bid) {
		return "trade/add";
	}

	@PostMapping("/trade/validate")
	public String validate(@Valid Trade trade, BindingResult result, Model model) {
		if (result.hasErrors())
			return "trade/add";
		model.addAttribute("trade", tradeService.updateTrade(trade));
		return "redirect:/trade/list";
	}

	@GetMapping("/trade/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Trade trade = tradeService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid update Id : " + id));
		model.addAttribute("trade", trade);
		return "trade/update";
	}

	@PostMapping("/trade/update/{id}")
	public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade, BindingResult result, Model model) {
		if (result.hasErrors())
			return "trade/update";
		tradeService.updateTrade(trade);
		model.addAttribute("trade", tradeService.findAllTrades());
		return "redirect:/trade/list";
	}

	@GetMapping("/trade/delete/{id}")
	public String deleteTrade(@PathVariable("id") Integer id, Model model) {
		Trade trade = tradeService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid update Id : " + id));
		tradeService.deleteTrade(trade);
		model.addAttribute("trade", tradeService.findAllTrades());
		return "redirect:/trade/list";
	}
}
