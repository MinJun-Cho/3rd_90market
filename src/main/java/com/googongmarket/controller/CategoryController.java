package com.googongmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category/*")
public class CategoryController {
	
	@GetMapping("category")
	public void category(Model model) {
		
		//log.info("list");
		//model.addAttribute("category", service.getList());
	}

	@GetMapping("appliances")
	public String appliances() {
		
		return "category/appliances";
	}
	
	@GetMapping("beauti")
	public String beauti() {
		
		return "category/beauti";
	}
	
	@GetMapping("books")
	public String books() {
		
		return "category/books";
	}
	
	@GetMapping("car")
	public String car() {
		
		return "category/car";
	}
	
	@GetMapping("etc")
	public String etc() {
		
		return "category/etc";
	}
	
	@GetMapping("fashion")
	public String fashion() {
		
		return "category/fashion";
	}
	
	@GetMapping("life")
	public String life() {
		
		return "category/life";
	}
	
	@GetMapping("men")
	public String men() {
		
		return "category/men";
	}
	
	@GetMapping("sport")
	public String sport() {
		
		return "category/sport";
	}
	
	@GetMapping("women")
	public String women() {
		
		return "category/women";
	}
	
	@GetMapping("young")
	public String young() {
		
		return "category/young";
	}
}
