package com.googongmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.googongmarket.service.ProductService;

import lombok.Setter;

@Controller
public class SearchController {
	
	@Setter(onMethod_ = {@Autowired})
	private ProductService service;
	
	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		
		service.search(keyword);
		
		model.addAttribute("search", service.search(keyword));
		model.addAttribute("keyword", keyword);
		
		return "product/search";
	}
}
