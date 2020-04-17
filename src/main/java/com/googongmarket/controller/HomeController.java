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
	public String home(ProductVO product, Model appliances, Model beauti, Model books, Model car, Model etc, Model fashion,
						Model life, Model men, Model sport, Model women, Model young) {
		
		product.setCategory("appliances");
		fashion.addAttribute("appliances", service.mainPage(product));
		
		product.setCategory("beauti");
		fashion.addAttribute("beauti", service.mainPage(product));
		
		product.setCategory("books");
		fashion.addAttribute("books", service.mainPage(product));
		
		product.setCategory("car");
		fashion.addAttribute("car", service.mainPage(product));
		
		product.setCategory("etc");
		fashion.addAttribute("etc", service.mainPage(product));
		
		product.setCategory("fashion");
		fashion.addAttribute("fashion", service.mainPage(product));
		System.out.println(service.mainPage(product));
		
		product.setCategory("life");
		fashion.addAttribute("life", service.mainPage(product));
		
		product.setCategory("men");
		fashion.addAttribute("men", service.mainPage(product));
		
		product.setCategory("sport");
		fashion.addAttribute("sport", service.mainPage(product));
		
		product.setCategory("women");
		women.addAttribute("women", service.mainPage(product));
		
		product.setCategory("young");
		fashion.addAttribute("young", service.mainPage(product));
		
		return "home";
	}
	
	@GetMapping("/product")
	public String product() {
		
		return "product";
	}
}
