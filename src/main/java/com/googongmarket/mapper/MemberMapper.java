package com.googongmarket.mapper;

import com.googongmarket.domain.MemberVO;

public interface MemberMapper {

	public String emailCheck(String email);
	
	public void joinMember(MemberVO memberVO);
	
	public String loginPasswdCheck(String email);
	
	public MemberVO getLoginMemberInfo(MemberVO tempLoginMember);
	
	public MemberVO getModifyMemberInfo(int id);
	
	public void modifyMemberInfo(MemberVO modifyMember);
	
}
