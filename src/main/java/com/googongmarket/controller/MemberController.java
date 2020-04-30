package com.googongmarket.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.mail.MessagingException;
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
import org.springframework.web.bind.annotation.RequestParam;

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
	public String join(@ModelAttribute("memberVO") MemberVO memberVO) throws UnsupportedEncodingException {
		
		return "member/signup";
	}
	
	@PostMapping("postSignup")
	public String postJoin(@Valid @ModelAttribute("memberVO") MemberVO memberVO, BindingResult result) throws UnsupportedEncodingException, MessagingException {
		
		if(result.hasErrors()) {
			
			return "member/signup";
		}
		
		service.joinMember(memberVO);
		
		return "member/signup_success";
	}
	
	@GetMapping("emailConfirm")
	public String emailConfirm(@RequestParam("id") String id, @ModelAttribute("memberVO") MemberVO memberVO) {
		
		memberVO.setValid("Y");
		memberVO.setAuthkey(null);
		
		service.memberValid(memberVO);
		
		return "/member/emailconfirm_ok";
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
	
	@GetMapping("delete")
	public String delete(@ModelAttribute("deleteMember") MemberVO deleteMember) {
		
		service.getDeleteMemberInfo(deleteMember);
		
		return "member/delete";
	}
	
	@PostMapping("/postDelete")
	public String postDelete(@Valid @ModelAttribute("deleteMember") MemberVO deleteMember, BindingResult result) {
		
		System.out.println("before delete : " + deleteMember);
		
		if(result.hasErrors()) {
			
			return "member/delete";
		}
		
		service.deleteMember(deleteMember);
		
		System.out.println("after delete : " + deleteMember);
		
		if(loginMember.isMemberLogin() == false) {
		
			return "member/delete_success";
			
		} else {
			
			return "member/delete_fail";
		}
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
