package com.lhdx.www.server.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhdx.www.server.model.Report;
import com.lhdx.www.server.service.ReportService;
import com.lhdx.www.server.service.TreeService;

@Controller
public class ReportController {

	@Resource(name = "reportService")
	private ReportService reportService;
	
	@Resource(name = "treeService")
	private TreeService treeService;

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
	
	@RequestMapping(value = "/getTreeList")
	public @ResponseBody
	Map getTreeList() {
		return treeService.findTree();
	}
}
