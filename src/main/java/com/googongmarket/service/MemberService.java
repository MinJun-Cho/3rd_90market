package com.googongmarket.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.googongmarket.domain.MemberVO;

public interface MemberService {

	public boolean emailCheck(String email);
	
	public void memberValid(MemberVO memberVO);
	
	public void joinMember(MemberVO memberVO) throws MessagingException, UnsupportedEncodingException;
	
	public void getLoginMemberInfo(MemberVO tempLoginMember);
	
	public void getModifyMemberInfo(MemberVO modifyMember);
	
	public void modifyMemberInfo(MemberVO modifyMember);
	
	public void getDeleteMemberInfo(MemberVO deleteMember);
	
	public void deleteMember(MemberVO deleteMember);
}
