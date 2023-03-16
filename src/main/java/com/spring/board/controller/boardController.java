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
	
	
	
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public String getListPageSearch(Model model,@RequestParam("num") int num,@RequestParam(value = "searchType",required = false, defaultValue = "title") String searchType,
			   @RequestParam(value = "keyword",required = false, defaultValue = "") String keyword)throws Exception {
		int count=service.count();
		int postNum=10;
		int pageNum=(int)Math.ceil((double)count/postNum); 
		int displayPost = (num-1)*postNum;
		
		int pageNum_cnt=10;
		int endPageNum=(int)(Math.ceil((double)num/(double)pageNum_cnt)*pageNum_cnt);
		int startPageNum=endPageNum-(pageNum_cnt-1);
		
		int endPageNum_tmp = (int)(Math.ceil((double)count/(double)pageNum_cnt));
		
		if(endPageNum>endPageNum_tmp) {
			endPageNum=endPageNum_tmp;
		}
		
		boolean prev= startPageNum==1?false:true;
		boolean next=endPageNum*pageNum_cnt>=count?false:true;
		
		List<boardVO> list;
		list = service.listPageSearch(displayPost,postNum,searchType,keyword);
		
		model.addAttribute("list",list);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("startPageNum",startPageNum);
		model.addAttribute("endPageNum",endPageNum);
		model.addAttribute("prev",prev);
		model.addAttribute("next",next);
		model.addAttribute("select",num);
		
		return "board/listPage";
		
	}
	
	
	
}
