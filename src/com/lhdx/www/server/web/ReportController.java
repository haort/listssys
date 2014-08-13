package com.lhdx.www.server.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhdx.www.server.model.Report;
import com.lhdx.www.server.service.ReportService;

@Controller
public class ReportController {

	@Resource(name = "reportService")
	private ReportService reportService;

	@RequestMapping(value = "/reportList")
	public @ResponseBody
	Map getReports(
			@RequestParam(value = "start", required = false) int start,
			@RequestParam(value = "limit", required = false) int size,
			@RequestParam(value = "record", required = false) String record) {
		return reportService.findReports(start, size, record);
	}
}
