package com.lhdx.www.server.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhdx.www.server.model.Report;
import com.lhdx.www.server.service.ReportService;

@Controller
public class ReportController {

	@Resource(name="reportService") 
	private ReportService reportService;
	
	@RequestMapping(value = "/reportList")
	public @ResponseBody List<Report> getReports(@RequestParam(value = "record", required = false) String record) {
		List<Report> list = reportService.findReports(record);
		return list;
	}
}


