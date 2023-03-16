package com.spring.board.controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.Interceptor;
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
import com.spring.board.service.memberService;


@Controller
@Service
public class memberController {
	protected final Logger logger = LoggerFactory.getLogger(Interceptor.class);
	
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
	public String login(memberVO vo, HttpServletRequest req,Model model) throws Exception{
		logger.info("post login");
		memberVO login = service.login(vo);
		
		
		if(login == null) {
			return "redirect:/";
			
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("member", login);
			session.setAttribute("password", vo.getUserPass());
			session.setAttribute("name",vo.getUserId());
			return "redirect:/listPage?num=1";
		}
	}
	

	@RequestMapping(value = "/", produces="text/plain;charset=UTF-8")
    public String home() throws Exception {
		
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
	
	//패스워드 유효성검사
	@RequestMapping(value = "/pwCheck", method = RequestMethod.POST)
	@ResponseBody
	public boolean PwCheck(String pw) {		
		logger.info("PwCheck");		
		
		boolean check = false;	

		String pw_chk = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*?&`~'\\\"+=])[A-Za-z[0-9]$@$!%*?&`~'\\\"+=]{6,18}$";
				
		Pattern pattern_symbol = Pattern.compile(pw_chk);		
		Matcher matcher_symbol = pattern_symbol.matcher(pw);		
		
		if(matcher_symbol.find()) {	
			check = true;
		}		
		return check;
	}
	
	//회원정보 수정
	@RequestMapping(value="/user/modify", method=RequestMethod.GET)
	public String getModify() throws Exception{
		logger.info("get modify");
		return "user/userModify";
	}
	
	@RequestMapping(value = "/user/modify",method=RequestMethod.POST)
	public String postModify(HttpSession session, memberVO vo) throws Exception{
		logger.info("post modify");
		
		service.userModify(vo);
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	//회원탈퇴
	@RequestMapping(value="/user/delete",method=RequestMethod.GET)
	public String getDelete() throws Exception{
		
		return "/user/userDelete";
	}
	
	@RequestMapping(value = "/user/delete", method=RequestMethod.POST)
	public String postDelete(HttpSession session,memberVO vo) throws Exception{
		service.userDelete(vo);
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
}
