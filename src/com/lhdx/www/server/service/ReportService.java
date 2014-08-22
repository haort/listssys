package com.lhdx.www.server.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lhdx.www.server.dao.ReportDao;
import com.lhdx.www.server.model.Report;


@Service("reportService")
public class ReportService {
	@Resource(name="reportDao")
	private ReportDao reportDao;
	
	public Map<String,Object> findReports(int start,int size,String table,String admin,int deep){
		 List<Report> list = reportDao.selectReports(start, size, table,admin,deep);
		 long count = reportDao.countReports(table,admin,deep);
		 Map<String,Object> map = new HashMap<String,Object>();  
	     map.put("users", list);  
	     map.put("totalCount", count);
	    
		return map;
	}
	
	public void updateReports(Report r,String table){
		 reportDao.updateReports(r, table);
	}
	
	public void updateReportsOwn(String[] ids,String table,int uid,int deep){
		 reportDao.batchUpdateStudentWithMap(ids, table, uid,deep);
	}
}
