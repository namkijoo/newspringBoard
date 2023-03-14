package com.spring.board.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.dto.memberVO;
import com.spring.board.intercepter.LoggerInterceptor;
import com.spring.board.service.memberService;

@Controller
@Service
public class memberController {
	protected final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Autowired
	memberService service;
	
	//회원가입
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public String getRegister() throws Exception{
		logger.debug("get register");
		return "user/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(memberVO vo) throws Exception{
		logger.debug("post register");
		service.register(vo);
		return "redirect:/"; 
	}
	
	
	
	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(memberVO vo, HttpServletRequest req) throws Exception{
		logger.info("post login");
		
		memberVO login = service.login(vo);
		System.out.println("ddddddddddddddddddddddddddddddddddddddddddd"+login.getUserName());
		
		if(login == null) {
			return "redirect:/";
			
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("member", login);
			return "redirect:/boardList";
		}	
	}
	

	@RequestMapping(value = "/", produces="text/plain;charset=UTF-8")
    public String home() {
		logger.debug("==== login 화면====");
		return "user/login";
	}
	
	
	//로그아웃
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception{
		logger.debug("logout메서드 진입");
		
		HttpSession session = request.getSession();
			
		session.invalidate();
			
		return "redirect:/";
	}
	
	
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value = "/idCheck")
	public int idCheck(@RequestParam(value="userId") String userId) throws Exception{
		int cnt = service.idCheck(userId);
		return cnt;
	}
}
