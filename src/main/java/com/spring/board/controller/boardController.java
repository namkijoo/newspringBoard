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
	
	
	//페이징 + 검색
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public String getListPageSearch(Model model,@RequestParam("num") int num,@RequestParam(value = "searchType",required = false, defaultValue = "title") String searchType,
			   @RequestParam(value = "keyword",required = false, defaultValue = "") String keyword)throws Exception {
		
		//게시물 총갯수
		int count=service.searchCount(searchType,keyword);
		
		//한 페이지에 출력할 게시물 갯수
		int postNum=10;
		
		//하단 페이징 번호(번호가 몇번까지 필요한지 계산)
		int pageNum=(int)Math.ceil((double)count/postNum);
		
		//출력 게시물 
		int displayPost = (num-1)*postNum;
		
		//하단에 표시할 페이징 번호의 갯수
		int pageNum_cnt=10;
		
		//표시되는 페이지 번호 중 마지막 번호
		int endPageNum=(int)(Math.ceil((double)num/(double)pageNum_cnt)*pageNum_cnt);
		
		//표시되는 페이지 번호 중 첫번재 번호
		int startPageNum=endPageNum-(pageNum_cnt-1);
		
		//마지막 번호 재계산
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
		
		//시작 및 끝 번호
		model.addAttribute("startPageNum",startPageNum);
		model.addAttribute("endPageNum",endPageNum);
		
		//이전 및 다음
		model.addAttribute("prev",prev);
		model.addAttribute("next",next);
		
		//현재 페이지
		model.addAttribute("select",num);
		
		model.addAttribute("searchType",searchType);
		model.addAttribute("keyword",keyword);
		
		return "board/listPage";
		
	}
	
	
	
}
