package com.googongmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.googongmarket.domain.ProductVO;
import com.googongmarket.service.ProductService;

import lombok.Setter;

@Controller
public class HomeController {
	
	@Setter(onMethod_ = {@Autowired})
	private ProductService service;

	@GetMapping("/")
	public String home(ProductVO product, Model model) {
		
		
		product.setCategory("fashion");
		model.addAttribute("fashion", service.mainPage(product));
		System.out.println(service.mainPage(product));
		
		return "home";
	}
	
	@GetMapping("/product")
	public String product() {
		
		return "product";
	}
}
