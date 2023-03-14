package com.spring.board.service;

import com.spring.board.dto.memberVO;

public interface memberService {
	//회원가입
	public void register(memberVO vo) throws Exception;
	
	//로그인
	public memberVO login(memberVO vo) throws Exception;
	
	//아이디 중복체크
	public int idCheck(String userId) throws Exception;
}
