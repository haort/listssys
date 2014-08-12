package com.lhdx.www.server.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lhdx.www.server.dao.ReportDao;
import com.lhdx.www.server.model.Report;


@Service("reportService")
public class ReportService {
	@Resource(name="reportDao")
	private ReportDao reportDao;
	
	public List<Report> findReports(){
		return reportDao.selectReports();
	}
}
