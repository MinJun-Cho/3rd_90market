package com.googongmarket.service;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.googongmarket.domain.MemberVO;
import com.googongmarket.mapper.MemberMapper;
import com.googongmarket.util.MailUtils;
import com.googongmarket.util.TempKey;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = {@Autowired})
	private MemberMapper mapper;
	
	@Resource(name = "loginMember")
	@Lazy
	private MemberVO loginMember;
	
	@Setter(onMethod_ = {@Autowired})
	private JavaMailSender mailSender;
	
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
	public void memberValid(MemberVO memberVO) {
		
		mapper.memberValid(memberVO);
	}
	
	@Override
	public void joinMember(MemberVO memberVO) throws MessagingException, UnsupportedEncodingException {
		
		String hashPasswd = BCrypt.hashpw(memberVO.getPasswd(), BCrypt.gensalt());
		memberVO.setPasswd(hashPasswd);
		
		//System.out.println(memberVO.getUsername());
		//System.out.println(memberVO.getNickname());
		
		mapper.joinMember(memberVO);
		
		String authKey = new TempKey().getKey(false, 50);
		
		memberVO.setAuthkey(authKey);
		mapper.updateAuthKey(memberVO);
		
		MailUtils sendMail = new MailUtils(mailSender);
		
		sendMail.setSubject("구공마켓 이메일 인증");
		sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
				.append("<p>구공마켓의 회원이 되어 주셔서 진심으로 감사드립니다!</p>")
				.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료되어,</p>")
				.append("<p>구공마켓 사이트를 정상적으로 이용 가능합니다.</p>")
				.append("<a href='http://localhost:8080/member/emailConfirm?id=")
				.append(memberVO.getId())
				.append("&email=")
				.append(memberVO.getEmail())
				.append("&authkey=")
				.append(authKey)
				.append("' target='_blank'>이메일 인증 확인</a>")
				.toString());
		sendMail.setFrom("j22sooj22soo@gmail.com", "구공마켓 관리자");
		sendMail.setTo(memberVO.getEmail());
		sendMail.send();
	}
	
	@Override
	public void getLoginMemberInfo(MemberVO tempLoginMember) {
		
		String plainPasswd = tempLoginMember.getPasswd();
		String hashPasswd = mapper.loginPasswdCheck(tempLoginMember.getEmail());
		
		if(hashPasswd != null) {
			
			if(BCrypt.checkpw(plainPasswd, hashPasswd)) {
				
				tempLoginMember.setPasswd(hashPasswd);
				
				MemberVO tempLoginMember2 = mapper.getLoginMemberInfo(tempLoginMember);
				
				if(tempLoginMember2.getValid().contains("N")) {
					
					tempLoginMember.setValid("N");
					
				} else if(tempLoginMember2 != null) {
					
					tempLoginMember.setValid("Y");
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
		modifyMember.setValid(tempModifyMember.getValid());
		modifyMember.setId(loginMember.getId());
	}
	
	@Override
	public void modifyMemberInfo(MemberVO modifyMember) {
		
		modifyMember.setId(loginMember.getId());
		
		String hashPasswd = BCrypt.hashpw(modifyMember.getPasswd(), BCrypt.gensalt());
		modifyMember.setPasswd(hashPasswd);
		
		mapper.modifyMemberInfo(modifyMember);
	}
	
	@Override
	public void getDeleteMemberInfo(MemberVO deleteMember) {
		
		MemberVO tempDeleteMember = mapper.getDeleteMemberInfo(loginMember.getId());
		
		deleteMember.setEmail(tempDeleteMember.getEmail());
		deleteMember.setId(loginMember.getId());
	}
	
	@Override
	public void deleteMember(MemberVO deleteMember) {
		
		String plainPasswd = deleteMember.getPasswd();
		String hashPasswd = mapper.loginPasswdCheck(deleteMember.getEmail());
		
		if(hashPasswd != null) {
			
			if(BCrypt.checkpw(plainPasswd, hashPasswd)) {
				
				deleteMember.setPasswd(hashPasswd);
				
				mapper.deleteMember(deleteMember);
				
				loginMember.setMemberLogin(false);
			}
		}
	}
}
