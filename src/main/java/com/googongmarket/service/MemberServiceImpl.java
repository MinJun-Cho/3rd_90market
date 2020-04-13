package com.googongmarket.service;

import javax.annotation.Resource;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.googongmarket.domain.MemberVO;
import com.googongmarket.mapper.MemberMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = {@Autowired})
	private MemberMapper mapper;
	
	@Resource(name = "loginMember")
	@Lazy
	private MemberVO loginMember;
	
	@Override
	public boolean emailCheck(String email) {
		
		String checkEmail = mapper.emailCheck(email);
		
		if(checkEmail == null) {
			
			return true;
		} else {
			
			return false;
		}
	}
	
	@Override
	public void joinMember(MemberVO memberVO) {
		
		String hashPasswd = BCrypt.hashpw(memberVO.getPasswd(), BCrypt.gensalt());
		memberVO.setPasswd(hashPasswd);
		
		mapper.joinMember(memberVO);
		
	}
	
	@Override
	public void getLoginMemberInfo(MemberVO tempLoginMember) {
		
		String plainPasswd = tempLoginMember.getPasswd();
		String hashPasswd = mapper.loginPasswdCheck(tempLoginMember.getEmail());
		
		if(hashPasswd != null) {
			
			if(BCrypt.checkpw(plainPasswd, hashPasswd)) {
				
				tempLoginMember.setPasswd(hashPasswd);
				
				MemberVO tempLoginMember2 = mapper.getLoginMemberInfo(tempLoginMember);
				
				if(tempLoginMember2 != null) {
					
					loginMember.setId(tempLoginMember2.getId());
					loginMember.setEmail(tempLoginMember2.getEmail());
					loginMember.setMemberLogin(true);
				}
			}
		}
	}
	
	@Override
	public void getModifyMemberInfo(MemberVO modifyMember) {
		
		MemberVO tempModifyMember = mapper.getModifyMemberInfo(loginMember.getId());
		
		modifyMember.setEmail(tempModifyMember.getEmail());
		modifyMember.setUsername(tempModifyMember.getUsername());
		modifyMember.setNickname(tempModifyMember.getNickname());
		modifyMember.setPhone(tempModifyMember.getPhone());
		modifyMember.setId(loginMember.getId());
	}
	
	@Override
	public void modifyMemberInfo(MemberVO modifyMember) {
		
		modifyMember.setId(loginMember.getId());
		
		String hashPasswd = BCrypt.hashpw(modifyMember.getPasswd(), BCrypt.gensalt());
		modifyMember.setPasswd(hashPasswd);
		
		mapper.modifyMemberInfo(modifyMember);
		
	}
}
