package com.googongmarket.service;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.googongmarket.util.NaverLoginApi;

@Service
public class AuthKakaoService {

	private final static String APP_KEY = "8bbb1eb71d7988c5d69987bce11c1f25";
	private final static String REDIRECT_URI = "http://localhost:8080/auth/kakao/callback";
	private final static String SESSION_STATE = "oauth_state";
	private final static String PROFILE_API_URL = "https://kapi.kakao.com/v1/user/access_token_info";
		
	public String getAuthorizeationUrl(HttpSession session) {
		
		String state = generateRandomString();
		
		setSession(session, state);
		
		OAuth20Service oauthService = new ServiceBuilder()
				.apiKey(APP_KEY)
				.callback(REDIRECT_URI)
				.state(state)
				.build(NaverLoginApi.instance());
		
		return oauthService.getAuthorizationUrl();
	}
	
	public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException, InterruptedException, ExecutionException {
		
		String sessionState = getSession(session);
		
		if(StringUtils.pathEquals(sessionState, state)) {
			
			OAuth20Service oauthService = new ServiceBuilder()
					.apiKey(APP_KEY)
					.callback(REDIRECT_URI)
					.state(state)
					.build(NaverLoginApi.instance());
			
			OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
			
			return accessToken;
		}
		
		return null;
 	}
	
	private String generateRandomString() {
		
		return UUID.randomUUID().toString();
	}
	
	private void setSession(HttpSession session, String state) {
		
		session.setAttribute(SESSION_STATE, state);
	}
	
	private String getSession(HttpSession session) {
		
		return (String) session.getAttribute(SESSION_STATE);
	}
	
	public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException {
		
		OAuth20Service oauthService = new ServiceBuilder()
				.apiKey(APP_KEY)
				.callback(REDIRECT_URI).build(NaverLoginApi.instance());
		
		OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
		
		oauthService.signRequest(oauthToken, request);
		
		Response response = request.send();
		
		return response.getBody();
	}
}
