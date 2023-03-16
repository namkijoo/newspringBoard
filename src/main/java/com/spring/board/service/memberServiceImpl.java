package com.spring.board.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.memberDAO;
import com.spring.board.dto.memberVO;

@Service
public class memberServiceImpl implements memberService {
	@Autowired 
	memberDAO dao;
	
	//회원가입
	@Override
	public void register(memberVO vo) throws Exception {
		dao.register(vo);
	}
	
	//로그인
	@Override
	public memberVO login(memberVO vo) throws Exception{
		return dao.login(vo);
	}
	
	//아이디 중복체크
	public int idCheck(String userId) throws Exception{
		return dao.idCheck(userId);
	}
	
	//비번 중복체크
	public String pwCheck(String userId) throws Exception{
		return dao.pwCheck(userId);
	}
	
	public void userModify(memberVO vo) throws Exception{
		dao.userModify(vo);
	};
	
	//회원탈퇴
	public void userDelete(memberVO vo) throws Exception{
		 dao.userDelete(vo);
	}
	
}
