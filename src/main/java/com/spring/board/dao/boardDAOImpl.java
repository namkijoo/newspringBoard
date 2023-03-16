package com.spring.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dto.boardVO;

@Service
public class boardDAOImpl implements boardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.spring.board.BoardMapper";
	
	//게시판리스트
	@Override
	public List<boardVO> list() throws Exception {
		return sqlSession.selectList(namespace+".boardList");
	}
	
	//게시판 작성
	@Override
	public void boardWrite(boardVO boardVO) throws Exception{
		sqlSession.insert(namespace+".boardWrite",boardVO);
	}
	
	//게시판상세
	@Override
	public boardVO boardDetail(int bo_no) throws Exception{
		return sqlSession.selectOne(namespace+".boardDetail",bo_no);
	}
	
	//게시물삭제
	@Override
	public void boardDelete(int bo_no) throws Exception{
		sqlSession.delete(namespace+".boardDelete",bo_no);
	}
	
	//게시물수정
	@Override
	public void boardUpdate(boardVO boardVO) throws Exception{
		sqlSession.update(namespace+".boardUpdate",boardVO);
	}
	
	//게시물 총갯수
	@Override
	public int count() throws Exception{
		return sqlSession.selectOne(namespace+".count");
	}
	
	//게시물 목록 + 페이징
	@Override
	public List<boardVO> listPage(int displayPost, int postNum) throws Exception{
		HashMap<String,Integer> data = new HashMap<String,Integer>();
		 data.put("displayPost", displayPost);
		 data.put("postNum",postNum);
		 
		 return sqlSession.selectList(namespace+".listPage",data);
	}
}
