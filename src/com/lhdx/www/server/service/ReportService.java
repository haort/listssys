package com.lhdx.www.server.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lhdx.www.server.dao.ReportDao;
import com.lhdx.www.server.dao.UserDao;
import com.lhdx.www.server.model.Report;
import com.lhdx.www.server.model.User;


@Service("reportService")
public class ReportService {
	@Resource(name="reportDao")
	private ReportDao reportDao;
	@Resource(name="userDao")
	private UserDao userDao;
	
	public Map<String,Object> findReports(int start,int size,String table,User user,String isSend){
		 List<Report> list = reportDao.selectReports(start, size, table,user,isSend);
		 long count = reportDao.countReports(table,user,isSend);
		 Map<String,Object> map = new HashMap<String,Object>();  
	     map.put("users", list);  
	     map.put("totalCount", count);
	    
		return map;
	}
	
	public void updateReports(Report r,String table){
		 reportDao.updateReports(r, table);
	}
	
	public void updateReportsOwn(String[] ids,String table,int uid){
		 User u = userDao.selectuUserById(uid);
		 reportDao.batchUpdateStudentWithMap(ids, table,u);
	}
}
