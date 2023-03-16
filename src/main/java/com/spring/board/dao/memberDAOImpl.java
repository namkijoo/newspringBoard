package com.spring.board.dao;




import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.board.dto.memberVO;

@Service
public class memberDAOImpl implements memberDAO {
	private static final String namespace = "com.spring.board.memberMapper";
	
	@Autowired
	SqlSession sqlSession;

	//회원가입
	@Override
	public void register(memberVO vo) throws Exception {
		sqlSession.insert(namespace+".register",vo);
	}
	
	//로그인
	@Override
	public memberVO login(memberVO vo) throws Exception{
		return sqlSession.selectOne(namespace+".login",vo);
	}
	
	//아이디 중복체크
	@Override
	public int idCheck(String userId) throws DataAccessException{
		return sqlSession.selectOne(namespace+".idCheck",userId);
	}
	
	//회원정보 수정
	@Override
	public void userModify(memberVO vo) throws Exception{
		sqlSession.update(namespace+".userModify",vo);
	}
	
	//회원탈퇴
	@Override
	public void userDelete(memberVO vo) throws Exception{
		sqlSession.delete(namespace+".userDelete",vo);
	}
}
