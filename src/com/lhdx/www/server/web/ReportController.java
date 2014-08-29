package com.lhdx.www.server.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhdx.www.server.model.Report;
import com.lhdx.www.server.model.Tree;
import com.lhdx.www.server.model.User;
import com.lhdx.www.server.service.PieService;
import com.lhdx.www.server.service.ReportService;
import com.lhdx.www.server.service.TreeService;

@Controller
@RequestMapping(value = "/service")
public class ReportController {

	@Resource(name = "reportService")
	private ReportService reportService;
	
	@Resource(name = "treeService")
	private TreeService treeService;

	@Resource(name = "pieService")
	private PieService pieService;
	
	@RequestMapping(value = "/reportList")
	public @ResponseBody
	Map getReports(
			@RequestParam("start") int start,
			@RequestParam("limit") int size,
			@RequestParam("table") String table,HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();  
		User u = getUser(request);
		if(u!=null){
			map = reportService.findReports(start, size, table,u,null);
		}
		return map;
	}
	
	@RequestMapping(value = "/adminReportList")
	public @ResponseBody
	Map getAdminReports(
			@RequestParam("start") int start,
			@RequestParam("limit") int size,
			@RequestParam("table") String table,HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();  
		User u = getUser(request);
		if(u!=null){
				map=reportService.findReports(start, size, table,u,"SENDLIST");
		}
		return map;
		
	}
	
	@RequestMapping(value = "/updateState")
	public @ResponseBody
	void updateState(
			@RequestBody Report r,@RequestParam("table") String table) {
		reportService.updateReports(r, table);
	}
	
	@RequestMapping(value = "/getTreeListByList")
	public @ResponseBody
	List getTreeListByList(HttpServletRequest request) {
		User u = getUser(request);
		List<Tree> list = treeService.findTreeByList();
		if(u!=null){
			if(u.getAuthority().equals("admin")){
				 Tree listManager = new Tree();
				 listManager.setText("清单管理");
				 listManager.setLeaf(false);
				 Tree userManager = new Tree();
				 userManager.setText("用户管理");
				 userManager.setId("ACTION_USER");
				 userManager.setLeaf(false);
				 Tree sendList = new Tree();
				 sendList.setId("ACTION_SEND");
				 sendList.setLeaf(false);
				 sendList.setText("分配清单");
				 Tree newList = new Tree();
				 newList.setId("ACTION_NEW");
				 newList.setLeaf(false);
				 newList.setText("新建派单");
				 listManager.getChildren().add(sendList);
				 listManager.getChildren().add(newList);
				 list.add(listManager);
				 list.add(userManager);
			}
		}
		return list;
	}
	
	@RequestMapping(value = "/getPie")
	public @ResponseBody
	List getPie(@RequestParam("table") String table,HttpServletRequest request) {
		User u = getUser(request);
		List list = new ArrayList();
		if(u!=null){
			list = pieService.findPie(table,u);
		}
		return list;
	}
	
	@RequestMapping(value = "/updateOwner")
	public @ResponseBody
	String updateOwner(
			@RequestParam("userid") int id,
			@RequestParam("recordids") String[] ids,
			@RequestParam("table") String table,HttpServletRequest request) {
		User u = getUser(request);
		if(u!=null){
			if(u.getAuthority().equals("admin")){
				reportService.updateReportsOwn(ids, table, id);
			}
		}
		
		return "Success";
	}
	
	private User getUser(HttpServletRequest request){
		if(request.getSession().getAttribute("user")!=null){
			User u = (User) request.getSession().getAttribute("user");
			return u;
		}
		else return null;
	}
}
