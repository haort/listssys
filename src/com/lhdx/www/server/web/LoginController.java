package com.lhdx.www.server.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	private static final String USERNAME = "hao";
	private static final String PASSWORD = "123";
	
	@RequestMapping("/")
	public String index(){
		return "login";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(String username,String password,HttpServletRequest request){
		System.out.println("hello"+username+password);
		ModelAndView mv=new ModelAndView("");
		if( USERNAME.equals(username)&& PASSWORD.equals(password)){
			request.getSession().setAttribute("user", username);
			mv.setViewName("index");
		}else{
			mv.setViewName("login");
			mv.addObject("username",username);
			mv.addObject("message", "username or password error ");
		}
		return mv;
	}
	
	
	@RequestMapping(value="/loginout")
	public ModelAndView loginOut(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		request.getSession().removeAttribute("user");
		System.out.println("remove user");
		return mv;
	}

}
