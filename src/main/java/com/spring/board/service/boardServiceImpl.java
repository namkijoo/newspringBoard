package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.boardDAO;
import com.spring.board.dto.boardVO;

@Service
public class boardServiceImpl implements boardService {
	
	@Autowired
	private boardDAO dao;
	
	@Override
	//게시판리스트
	public List<boardVO> list() throws Exception {	
		return dao.list();
	}
	
	//게시물 작성
	@Override
	public void boardWrite(boardVO boardVO) throws Exception{
		dao.boardWrite(boardVO);
	}
	
	//게시판 상세
	@Override
	public boardVO boardDetail(int bo_no) throws Exception{
		return dao.boardDetail(bo_no);
	}
	
	//게시물삭제
	@Override
	public void boardDelete(int bo_no) throws Exception{
		dao.boardDelete(bo_no);
	}
	
	//게시물 수정
	@Override
	public void boardUpdate(boardVO boardVO) throws Exception{
		dao.boardUpdate(boardVO);
	}
	
	//게시물 총 갯수
	@Override
	public int count() throws Exception{
		return dao.count();
	}
	
	//게시물 목록 + 페이징
	@Override
	public List<boardVO> listPage(int displayPost, int postNum) throws Exception{
		return dao.listPage(displayPost, postNum);
	}
	
	//게시물 목록 + 페이징 + 검색
		public List<boardVO> listPageSearch(
			int displayPost, int postNum, String searchType, String keyword) throws Exception{
			return  dao.listPageSearch(displayPost, postNum, searchType, keyword);
		}
	
}
