package com.googongmarket.mapper;

import com.googongmarket.domain.MemberVO;

public interface AuthMapper {

	public String idCheck(String email);
	
	public void joinAuthMember(MemberVO memberVO);
	
}
