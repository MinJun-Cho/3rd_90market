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
import org.springframework.web.bind.annotation.GetMapping;
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

//	@Autowired
//	private void setAuthNaverService(AuthNaverService naverService) {
//		
//		this.naverService = naverService;
//	}
	
	@GetMapping("/auth/naver/login")
	public String naverLogin(Model model, HttpSession session) {
		
		String naverAuthUrl = naverService.getAuthorizeationUrl(session);
		
		//System.out.println("네이버 : " + naverAuthUrl);
		
		model.addAttribute("url", naverAuthUrl);
		
		return "auth/naver/login";
	}
	
	@RequestMapping(value = "/auth/naver/callback", method = {RequestMethod.GET, RequestMethod.POST})
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session,
							HttpServletRequest request, MemberVO memberVO) throws IOException, InterruptedException, ExecutionException, ParseException {
		
		//System.out.println("여기는 callback");
		
		OAuth2AccessToken oauthToken;
		oauthToken = naverService.getAccessToken(session, code, state);
		//System.out.println("\noauthToken : " + oauthToken + "\n");
		
		naverProfile = naverService.getUserProfile(oauthToken);
		
		//System.out.println(naverLoginBO.getUserProfile(oauthToken).toString());
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject =(JSONObject) jsonParser.parse(naverProfile.toString());
		JSONObject response = (JSONObject) jsonObject.get("response");
		
		//System.out.println("response : " + response);
		
		memberVO.setEmail((String) response.get("email"));
		memberVO.setPasswd("NAVER");
		memberVO.setUsername((String) response.get("name"));
		memberVO.setNickname((String) response.get("nickname"));
		memberVO.setSocial_type("naver");
		
		//System.out.println(service.emailCheck((String) response.get("email")));
		
		if(service.emailCheck((String) response.get("email"))) {
			
			mapper.joinAuthMember(memberVO);
			int id = mapper.idCheck(memberVO.getEmail());
			//System.out.println("id : " + id);
			
			//service.joinMember(memberVO);
			
			loginMember.setId(id);
			loginMember.setEmail(memberVO.getEmail());
			loginMember.setMemberLogin(true);
		} else {
			
			int id = mapper.idCheck(memberVO.getEmail());
			
			loginMember.setId(id);
			loginMember.setEmail(memberVO.getEmail());
			loginMember.setMemberLogin(true);
		}
		
		model.addAttribute("result", naverProfile);
		//System.out.println(memberVO.getUsername());
		session.setAttribute("username", memberVO.getUsername());
		
		//System.out.println("\nresult : " + naverProfile + "\n");
		
		return "auth/naver/success";
	}
}
