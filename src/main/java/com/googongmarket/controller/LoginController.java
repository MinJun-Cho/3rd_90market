package com.googongmarket.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.googongmarket.domain.MemberVO;
import com.googongmarket.service.AuthNaverService;
import com.googongmarket.service.MemberService;
import com.googongmarket.validator.MemberValidator;

import lombok.Setter;

@Controller
@RequestMapping("/auth/*")
public class LoginController {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberService service;
	
	@Setter(onMethod_ = {@Autowired})
	private AuthNaverService naverService;
	
	@Resource(name = "loginMember")
	@Lazy
	private MemberVO loginMember;

	@GetMapping("login")
	public String login(@ModelAttribute("tempLoginMember") MemberVO tempLoginMember,
						@RequestParam(value = "fail", defaultValue = "false") boolean fail, Model model, HttpSession session) {
		
		String url = naverService.getAuthorizeationUrl(session);
		
		model.addAttribute("fail", fail);
		
		model.addAttribute("url", url);
		
		return "auth/login";
	}
	
	@PostMapping("postLogin")
	public String postLogin(@Valid @ModelAttribute("tempLoginMember") MemberVO tempLoginMember, BindingResult result, HttpSession session) {
		
		if(result.hasErrors()) {
			
			return "auth/login";
		}
		
		service.getLoginMemberInfo(tempLoginMember);
		
		
		if("N".equals(tempLoginMember.getValid())) {
				
			return "auth/no_email_confirm";
						
		}
		
		if(loginMember.isMemberLogin() == true) {
		
			service.getModifyMemberInfo(tempLoginMember);
		
			session.setAttribute("username", tempLoginMember.getUsername());
		
			return "auth/login_success";
			
		} else {
			
			return "auth/login_fail";
		}
	}
	
	@GetMapping("logout")
	public String logout() {
		
		loginMember.setMemberLogin(false);
		
		return "auth/logout";
	}
	
	@GetMapping("not_login")
	public String not_login() {
		
		return "auth/not_login";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		MemberValidator memberValidator = new MemberValidator();
		binder.addValidators(memberValidator);
		
	}
}
