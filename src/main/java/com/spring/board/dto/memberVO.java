package com.spring.board.dto;

import javax.validation.constraints.NotEmpty;

public class memberVO {
	private String userId;
	
	@NotEmpty(message="pw를 입력하세요")
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
