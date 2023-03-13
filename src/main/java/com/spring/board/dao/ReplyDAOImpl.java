package com.spring.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dto.ReplyVO;

@Service
public class ReplyDAOImpl implements ReplyDAO {
	@Autowired
	private SqlSession sql;

	private static String namespace = "com.spring.board.replyMapper";

	// 댓글 조회
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
	    return sql.selectList(namespace + ".replyList", bno);
	}

	// 댓글 작성
	@Override
	public void write(ReplyVO vo) throws Exception {
	    sql.insert(namespace + ".replyWrite", vo);
	}

	// 댓글 수정
	@Override
	public void replyModify(ReplyVO vo) throws Exception {
	    sql.update(namespace + ".replyModify", vo);
	}

	// 댓글 삭제
	@Override
	public void delete(ReplyVO vo) throws Exception {
	    sql.delete(namespace + ".replyDelete", vo);
	}
	
	//단일 댓글 조회
	@Override
	public ReplyVO replySelect(ReplyVO vo) throws Exception{
		return sql.selectOne(namespace+".replySelect",vo);
	}
}
