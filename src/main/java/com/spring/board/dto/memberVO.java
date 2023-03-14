package com.spring.board.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class memberVO {
	private String userId;
	
	@NotEmpty(message="pw를 입력하세요")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
	private String userPass;
	
	@NotEmpty(message="id를 입력하세요")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	
}
