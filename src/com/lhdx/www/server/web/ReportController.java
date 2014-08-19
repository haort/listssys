package com.lhdx.www.server.web;

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
			@RequestParam("table") String table) {
		return reportService.findReports(start, size, table);
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
		List<Tree> list = treeService.findTreeByList();
		if(request.getSession().getAttribute("user")!=null){
			User u = (User) request.getSession().getAttribute("user");
			if(u.getAuthority().equals("admin")){
				 Tree root = new Tree();
				 root.setId("ACTION_SEND");
				 root.setLeaf(false);
				 root.setText("分配清单");
				 list.add(root);
			}
		}
		return list;
	}
	
	@RequestMapping(value = "/getPie")
	public @ResponseBody
	List getPie(@RequestParam("table") String table) {
		return pieService.findPie(table);
	}
}
