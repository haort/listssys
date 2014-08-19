package com.lhdx.www.server.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lhdx.www.server.model.User;
import com.lhdx.www.server.service.UserService;

@Controller
public class LoginController {
	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping("/")
	public String index() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(String username, String password,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("");
		User u = userService.findUserByNameAndPwd(username, password);
		if (u != null) {
			request.getSession().setAttribute("user", u);
			mv.setViewName("redirect:/index");
		} else {
			mv.setViewName("forward:/");
			mv.addObject("username", username);
			mv.addObject("message", "username or password error ");
		}
		return mv;
	}
	
	@RequestMapping(value = "/index")
	public ModelAndView indexView() {
		ModelAndView mv = new ModelAndView("");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/loginout")
	public ModelAndView loginOut(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		request.getSession().removeAttribute("user");
		return mv;
	}

}
