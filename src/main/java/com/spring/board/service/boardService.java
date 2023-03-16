package com.spring.board.service;

import java.util.List;

import com.spring.board.dto.boardVO;


public interface boardService {
	//게시판리스트
	public List<boardVO> list() throws Exception;
	
	//게시물 작성
	public void boardWrite(boardVO boardVO) throws Exception;
	
	//게시물 상세
	public boardVO boardDetail(int bo_no) throws Exception;
	
	//게시물 삭제
	public void boardDelete(int bo_no) throws Exception;
	
	//게시물 수정
	public void boardUpdate(boardVO boardVO) throws Exception;
	
	//게시물 총 갯수
	public int count() throws Exception;
	
	//게시물 목록 +페이징
	public List<boardVO> listPage(int displayPost, int postNum) throws Exception;
}
