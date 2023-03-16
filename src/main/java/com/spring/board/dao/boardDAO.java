package com.spring.board.dao;

import java.util.List;

import com.spring.board.dto.boardVO;


public interface boardDAO {
	//게시판리스트
	public List<boardVO> list() throws Exception;
	
	//게시판작성
	public void boardWrite(boardVO boardVO) throws Exception;
	
	//게시물상세
	public boardVO boardDetail(int bo_no) throws Exception;
	
	//게시물삭제
	public void boardDelete(int bo_no) throws Exception;
	
	//게시물수정
	public void boardUpdate(boardVO boardVO) throws Exception;
	
	//게시물 총 갯수
	public int count() throws Exception;
	
	//게시물 목록 + 페이징
	public List<boardVO> listPage(int displayPost, int postNum) throws Exception;
	
	//게시물 목록 + 페이징 + 검색
	public List<boardVO> listPageSearch(int displayPost, int postNum, String searchType,String keyword) throws Exception;
}


