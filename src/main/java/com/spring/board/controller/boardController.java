package com.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.dto.ReplyVO;
import com.spring.board.dto.boardVO;
import com.spring.board.service.ReplyService;
import com.spring.board.service.boardService;


@Controller
@Service
public class boardController {
	
	@Autowired
	private boardService service;
	
	@Autowired 
	private ReplyService replyService;
	

	
	//리스트 화면
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String board(boardVO boardVO,Model model) throws Exception {
		List<boardVO> list;
		list = service.list();
		model.addAttribute("list",list);	
		return "board/boardList";	
	}
	
	//채팅방작성화면
	@RequestMapping(value="/boardWrite",method=RequestMethod.GET)
	public String boardWrite() throws Exception{
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "/boardWriteDo", method=RequestMethod.POST)
	public String boardWriteDo(boardVO boardVO) throws Exception{
		service.boardWrite(boardVO);
		return "redirect:/listPage?num=1";
	}
	
	//댓글 포함 상세화면
	@RequestMapping(value="/boardDetail", method=RequestMethod.GET)
	public String boardDetail(Model model,int bo_no) throws Exception{
		boardVO data = service.boardDetail(bo_no);
		model.addAttribute("data",data);
		
		List<ReplyVO> reply;
		reply = replyService.list(bo_no);
		model.addAttribute("reply",reply);
		return "board/boardDetail";
	}
	
	//삭제
	@RequestMapping(value="/boardDelete", method=RequestMethod.GET)
	public String boardDelete(int bo_no) throws Exception{
		service.boardDelete(bo_no);
		return "redirect:/listPage?num=1";
	}
	
	//수정
	@RequestMapping(value = "/boardUpdate", method=RequestMethod.GET)
	public String getupdate(int bo_no, Model model) throws Exception{
		boardVO data = service.boardDetail(bo_no);
		model.addAttribute("data",data);
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String postupdate(boardVO boardVO) throws Exception{
		service.boardUpdate(boardVO);
		return "redirect:/listPage?num=1";
	}
	
	//게시물 목록 +페이징 추가
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public String getboard(Model model,@RequestParam("num") int num) throws Exception {
		int count=service.count();
		int postNum=10;
		int pageNum=(int)Math.ceil((double)count/postNum); 
		int displayPost = (num-1)*postNum;
		
		List<boardVO> list;
		list = service.listPage(displayPost,postNum);
		model.addAttribute("list",list);
		model.addAttribute("pageNum",pageNum);
		
		return "board/listPage";
	}
	
	
}
