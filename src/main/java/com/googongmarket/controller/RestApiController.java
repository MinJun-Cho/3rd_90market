package com.googongmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.googongmarket.service.MemberService;

import lombok.Setter;

@RestController
public class RestApiController {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberService service;
	
	@GetMapping("/user/emailCheck/{email}")
	public String emailCheck(@PathVariable String email) {
		
		boolean chk = service.emailCheck(email + ".com");
		
		return chk + "";
	}
}
