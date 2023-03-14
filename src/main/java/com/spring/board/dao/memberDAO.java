package com.spring.board.dao;


import org.springframework.dao.DataAccessException;

import com.spring.board.dto.memberVO;

public interface memberDAO {
	//회원가입
	public void register(memberVO vo) throws Exception;
	
	//로그인
	public memberVO login(memberVO vo) throws Exception;
	
	//아이디 중복체크
	public int idCheck(String userId) throws DataAccessException;
	
}
