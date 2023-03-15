package com.spring.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.dto.ReplyVO;
import com.spring.board.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	 
	//댓글 쓰기
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String posttWirte(ReplyVO vo) throws Exception {
	    
	    replyService.write(vo);
	    
	    return "redirect:/boardDetail/?bo_no=" + vo.getBno();
	}
	
	//댓글 수정하기
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String getModify(@RequestParam("bno") int bno, @RequestParam("rno") int rno, Model model) throws Exception {
		ReplyVO vo = new ReplyVO();
		vo.setBno(bno);
		vo.setRno(rno);
		
		ReplyVO reply = replyService.replySelect(vo);
			 
		model.addAttribute("reply", reply);
		
		return "board/modify";
	}
	

	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String postModify(ReplyVO vo) throws Exception{
		replyService.replyModify(vo);
		
		return "redirect:/boardDetail/?bo_no="+vo.getBno();
	}
	
	//댓글 삭제하기
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String boardDelete(ReplyVO vo) throws Exception{
		replyService.delete(vo);
		return "redirect:/boardDetail/?bo_no="+vo.getBno();
	}
}
