package com.googongmarket.service;

import com.googongmarket.domain.MemberVO;

public interface MemberService {

	public boolean emailCheck(String email);
	
	public void joinMember(MemberVO memberVO);
	
	public void getLoginMemberInfo(MemberVO tempLoginMember);
	
	public void getModifyMemberInfo(MemberVO modifyMember);
	
	public void modifyMemberInfo(MemberVO modifyMember);
}
