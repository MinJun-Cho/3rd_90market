package com.googongmarket.controller;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.googongmarket.domain.MemberVO;
import com.googongmarket.mapper.AuthMapper;
import com.googongmarket.service.AuthNaverService;
import com.googongmarket.service.MemberService;

import lombok.Setter;

@Controller
public class AuthController {

	@Setter(onMethod_ = {@Autowired})
	private MemberService service;
	
	@Setter(onMethod_ = {@Autowired})
	private AuthMapper mapper;
	
	@Setter(onMethod_ = {@Autowired})
	private AuthNaverService naverService;
	
	private String naverProfile = null;
	
	@Resource(name = "loginMember")
	@Lazy
	private MemberVO loginMember;

	@RequestMapping(value = "/auth/naver/callback", method = {RequestMethod.GET, RequestMethod.POST})
	public String naverCallback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session,
							HttpServletRequest request, MemberVO memberVO) throws IOException, InterruptedException, ExecutionException, ParseException {
		
		OAuth2AccessToken oauthToken;
		oauthToken = naverService.getAccessToken(session, code, state);
		
		naverProfile = naverService.getUserProfile(oauthToken);
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject =(JSONObject) jsonParser.parse(naverProfile.toString());
		JSONObject response = (JSONObject) jsonObject.get("response");
		
		memberVO.setEmail((String) response.get("email"));
		memberVO.setPasswd("NAVER");
		memberVO.setUsername((String) response.get("name"));
		memberVO.setNickname((String) response.get("nickname"));
		memberVO.setSocial_type("naver");
		
		if(service.emailCheck((String) response.get("email"))) {
			
			mapper.joinAuthMember(memberVO);
			String id = mapper.idCheck(memberVO.getEmail());
			
			loginMember.setId(id);
			loginMember.setEmail(memberVO.getEmail());
			loginMember.setMemberLogin(true);
		} else {
			
			String id = mapper.idCheck(memberVO.getEmail());
			
			loginMember.setId(id);
			loginMember.setEmail(memberVO.getEmail());
			loginMember.setMemberLogin(true);
		}
		
		model.addAttribute("result", naverProfile);
		session.setAttribute("username", memberVO.getUsername());
		
		return "auth/naver/success";
	}
}
