package com.googongmarket.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {
	
	private int id;
	
	@Email
	@Size(max = 30)
	private String email;
	
	private boolean emailExist;
	private boolean memberLogin;
	
	public MemberVO() {
		
		this.emailExist = false;
		this.memberLogin = false;
	}
	
	@Size(min = 7, max = 20)
	private String passwd;
	
	@Size(min = 7, max = 20)
	private String passwd2;
	
	@Size(min = 2, max = 5)
	@Pattern(regexp = "[가-힣]*")
	private String username;
	
	@Size(min = 3, max = 7)
	@Pattern(regexp = "[가-힣a-zA-Z0-9]*")
	private String nickname;
	
	@Pattern(regexp = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}")
	private String phone;
	
	private String valid;
	private String social_type;
}
