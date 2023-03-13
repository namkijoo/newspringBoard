package com.spring.board.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class loginCheck {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@RequestMapping(value = "/loginCheck",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String logidnCheck(HttpServletRequest request) {
		logger.debug("=================loginCheck");
		System.out.println("request===="+request);
		if("admin".equals(request.getParameter("id"))&&"welcome1".equals(request.getParameter("pwd"))) {
			
			Map<String, String> map= new HashMap<String,String>();
			map.put("admin_id","admin");
			map.put("admin_name","administrator");
			request.getSession().setAttribute("logininfo", map);
			return "redirect:/boardList";
		}
		else {
			return "redirect:/";
		}
		
			
		
	}
}
