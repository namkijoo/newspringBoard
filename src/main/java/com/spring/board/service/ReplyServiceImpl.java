package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.ReplyDAO;
import com.spring.board.dto.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDAO dao;

	// 댓글 조회
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
	    return dao.list(bno);
	}
	
	//댓글 작성
	@Override
	public void write(ReplyVO vo) throws Exception {
	    dao.write(vo);
	}

	//댓글 수정
	@Override
	public void replyModify(ReplyVO vo) throws Exception {
	    dao.replyModify(vo);
	}

	//댓글 삭제
	@Override
	public void delete(ReplyVO vo) throws Exception {
	    dao.delete(vo);
	}
	
	// 단일 댓글 조회
	@Override
	public ReplyVO replySelect(ReplyVO vo) throws Exception {
		return dao.replySelect(vo);
	}
}
