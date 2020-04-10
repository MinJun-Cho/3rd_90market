package com.googongmarket.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.googongmarket.domain.MemberVO;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return MemberVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		MemberVO memberVO = (MemberVO) target;
		
		String memberName = errors.getObjectName();
		
		if(memberName.equals("memberVO") || memberName.equals("modifyMember")) {
			
			if(memberVO.getPasswd().equals(memberVO.getPasswd2()) == false) {
				
				errors.rejectValue("passwd", "NotEquals");
				errors.rejectValue("passwd2", "NotEquals");
			}
		}
		
		if(memberName.equals("memberVO")) {
			
			if(memberVO.isEmailExist() == false) {
				
				errors.rejectValue("email", "DontCheckEmailExist");
			}
		}
	}
}
