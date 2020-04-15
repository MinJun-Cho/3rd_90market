package com.googongmarket.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.googongmarket.domain.MemberVO;
import com.googongmarket.service.MemberService;
import com.googongmarket.validator.MemberValidator;

import lombok.Setter;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Setter(onMethod_ = {@Autowired})
	private MemberService service;
	
	@Resource(name = "loginMember")
	@Lazy
	private MemberVO loginMember;
	
	@GetMapping("signup")
	public String join(@ModelAttribute("memberVO") MemberVO memberVO) {
		
		return "member/signup";
	}
	
	@PostMapping("postSignup")
	public String postJoin(@Valid @ModelAttribute("memberVO") MemberVO memberVO, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "member/signup";
		}
		
		service.joinMember(memberVO);
		
		return "member/signup_success";
	}
	
	@GetMapping("modify")
	public String modify(@ModelAttribute("modifyMember") MemberVO modifyMember) {
		
		service.getModifyMemberInfo(modifyMember);
		
		return "member/modify";
	}
	
	@PostMapping("postModify")
	public String postModify(@Valid @ModelAttribute("modifyMember") MemberVO modifyMember, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "member/modify";
		}
		
		service.modifyMemberInfo(modifyMember);
		
		return "member/modify_success";
	}
	
	@GetMapping("myshop")
	public String myshop() {
		
		return "member/myshop";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		MemberValidator memberValidator = new MemberValidator();
		binder.addValidators(memberValidator);
		
	}
}
