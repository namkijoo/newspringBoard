package com.spring.board.login;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@RequestMapping(value = "/", produces="text/plain;charset=UTF-8")
    public String home(Locale locale, Model model) {
		logger.debug("==== login 화면====");
		return "user/login";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception{
		logger.debug("logout메서드 진입");
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return "redirect:/";
	}
}


