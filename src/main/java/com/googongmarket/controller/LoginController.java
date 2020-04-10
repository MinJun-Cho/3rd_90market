package com.googongmarket.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.googongmarket.domain.MemberVO;
import com.googongmarket.service.MemberService;
import com.googongmarket.validator.MemberValidator;

import lombok.Setter;

@Controller
public class LoginController {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberService service;
	
	@Resource(name = "loginMember")
	@Lazy
	private MemberVO loginMember;

	@GetMapping("/login")
	public String login(@ModelAttribute("tempLoginMember") MemberVO tempLoginMember,
						@RequestParam(value = "fail", defaultValue = "false") boolean fail, Model model) {
		
		model.addAttribute("fail", fail);
		
		return "login";
	}
	
	@PostMapping("/postLogin")
	public String postLogin(@Valid @ModelAttribute("tempLoginMember") MemberVO tempLoginMember, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "login";
		}
		
		service.getLoginMemberInfo(tempLoginMember);
		
		if(loginMember.isMemberLogin() == true) {
			
			return "login_success";
		} else {
			
			return "login_fail";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		loginMember.setMemberLogin(false);
		
		return "logout";
	}
	
	@GetMapping("/not_login")
	public String not_login() {
		
		return "not_login";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		MemberValidator memberValidator = new MemberValidator();
		binder.addValidators(memberValidator);
		
	}
}
