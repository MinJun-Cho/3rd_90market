package com.googongmarket.mapper;

import com.googongmarket.domain.MemberVO;

public interface MemberMapper {

	public String emailCheck(String email);
	
	public void updateAuthKey(MemberVO memberVO);
	
	public void memberValid(MemberVO memberVO);
	
	public void joinMember(MemberVO memberVO);
	
	public String loginPasswdCheck(String email);
	
	public MemberVO getLoginMemberValid(MemberVO memberVO);
	
	public MemberVO getLoginMemberInfo(MemberVO tempLoginMember);
	
	public MemberVO getModifyMemberInfo(String id);
	
	public void modifyMemberInfo(MemberVO modifyMember);
	
	public MemberVO getDeleteMemberInfo(String id);
	
	public int deleteMember(MemberVO deleteMember);
	
}
