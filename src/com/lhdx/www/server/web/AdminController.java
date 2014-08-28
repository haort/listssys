package com.lhdx.www.server.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
		if(request.getSession().getAttribute("user")!=null){
			User u = (User) request.getSession().getAttribute("user");
			if(u.getAuthority().equals("admin")){
				list = userService.findAdminTreeByParentId(u.getUid());
			}
		}
		return list;
	}
}
