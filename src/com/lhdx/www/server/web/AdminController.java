package com.lhdx.www.server.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhdx.www.server.model.AdminTree;
import com.lhdx.www.server.model.User;
import com.lhdx.www.server.service.UserService;

@Controller
@RequestMapping(value = "/service")
public class AdminController {

	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "/getAdminTreeList")
	public @ResponseBody
	List getTreeListByList(HttpServletRequest request) {
		List<AdminTree> list = null;
		User u = getUser(request);
		if(u!=null){
			if(u.getAuthority().equals("admin")){
				list = userService.findAdminTreeByParentId(u.getUid());
			}
		}
		return list;
	}
	
	@RequestMapping(value = "/getAdminUser")
	public @ResponseBody
	Map getAdminUser(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		User u = getUser(request);
		if(u!=null){
			if(u.getAuthority().equals("admin")){
				u = userService.findUsersByParentId();
			}
		}
		map.put("children", u);
		return  map;
	}
	
	
	private User getUser(HttpServletRequest request){
		if(request.getSession().getAttribute("user")!=null){
			User u = (User) request.getSession().getAttribute("user");
			return u;
		}
		else return null;
	}
	
	@RequestMapping(value = "/updateUserParentId")
	public @ResponseBody
	String updateUserParentId(
			@RequestParam("selectId") int uid,
			@RequestParam("targetDeep") int deep,
			@RequestParam("tagertId") int parentid,HttpServletRequest request) {
		User u = getUser(request);
		if(u!=null){
			if(u.getAuthority().equals("admin")){
				userService.updateUserParentId(uid,parentid,deep);
			}
		}
		
		return "Success";
	}
}
