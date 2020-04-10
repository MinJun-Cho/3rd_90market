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

import com.googongmarket.domain.MemberVO;
import com.googongmarket.service.MemberService;
import com.googongmarket.validator.MemberValidator;

import lombok.Setter;

@Controller
public class MemberController {

	@Setter(onMethod_ = {@Autowired})
	private MemberService service;
	
	@Resource(name = "loginMember")
	@Lazy
	private MemberVO loginMember;
	
	@GetMapping("/join")
	public String join(@ModelAttribute("memberVO") MemberVO memberVO) {
		
		return "join";
	}
	
	@PostMapping("/postJoin")
	public String postJoin(@Valid @ModelAttribute("memberVO") MemberVO memberVO, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "join";
		}
		
		service.joinMember(memberVO);
		
		return "join_success";
	}
	
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyMember") MemberVO modifyMember) {
		
		service.getModifyMemberInfo(modifyMember);
		
		return "modify";
	}
	
	@PostMapping("/postModify")
	public String postModify(@Valid @ModelAttribute("modifyMember") MemberVO modifyMember, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "modify";
		}
		
		service.modifyMemberInfo(modifyMember);
		
		return "modify_success";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		MemberValidator memberValidator = new MemberValidator();
		binder.addValidators(memberValidator);
		
	}
}
