package com.googongmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.googongmarket.domain.ProductVO;
import com.googongmarket.service.ProductService;

import lombok.Setter;

@Controller
@RequestMapping("/category/*")
public class CategoryController {
	
	@Setter(onMethod_ = {@Autowired})
	private ProductService service;
	
	@GetMapping("category")
	public void category(Model model) {
		
	}

	@GetMapping("appliances")
	public String appliances(ProductVO product, Model model) {
		
		product.setCategory("appliances");
		model.addAttribute("appliances", service.mainPage(product));
		
		return "category/appliances";
	}
	
	@GetMapping("beauti")
	public String beauti(ProductVO product, Model model) {
		
		product.setCategory("beauti");
		model.addAttribute("beauti", service.mainPage(product));
		
		return "category/beauti";
	}
	
	@GetMapping("books")
	public String books(ProductVO product, Model model) {
		
		product.setCategory("books");
		model.addAttribute("books", service.mainPage(product));
		
		return "category/books";
	}
	
	@GetMapping("car")
	public String car(ProductVO product, Model model) {
		
		product.setCategory("car");
		model.addAttribute("car", service.mainPage(product));
		
		return "category/car";
	}
	
	@GetMapping("etc")
	public String etc(ProductVO product, Model model) {
		
		product.setCategory("etc");
		model.addAttribute("etc", service.mainPage(product));
		
		return "category/etc";
	}
	
	@GetMapping("fashion")
	public String fashion(ProductVO product, Model model) {
		
		product.setCategory("fashion");
		model.addAttribute("fashion", service.mainPage(product));
		
		return "category/fashion";
	}
	
	@GetMapping("life")
	public String life(ProductVO product, Model model) {
		
		product.setCategory("life");
		model.addAttribute("life", service.mainPage(product));
		
		return "category/life";
	}
	
	@GetMapping("men")
	public String men(ProductVO product, Model model) {
		
		product.setCategory("men");
		model.addAttribute("men", service.mainPage(product));
		
		return "category/men";
	}
	
	@GetMapping("sport")
	public String sport(ProductVO product, Model model) {
		
		product.setCategory("sport");
		model.addAttribute("sport", service.mainPage(product));
		
		return "category/sport";
	}
	
	@GetMapping("women")
	public String women(ProductVO product, Model model) {
		
		product.setCategory("women");
		model.addAttribute("women", service.mainPage(product));
		
		return "category/women";
	}
	
	@GetMapping("young")
	public String young(ProductVO product, Model model) {
		
		product.setCategory("young");
		model.addAttribute("young", service.mainPage(product));
		
		return "category/young";
	}
}
