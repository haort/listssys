package com.lhdx.www.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lhdx.www.server.model.Report;

@Component("reportDao")
public class ReportDao extends BaseDao {
	private static final String NAMESPACE = "com.lhdx.www.server.dao.ReportDao";
	private static final String SELECTREPORTS = ".selectReports";
	private static final String COUNTREPORTS = ".countReports";
	private static final String UPDATEREPORTBYID = ".updateReportById";

	public List<Report> selectReports(int start,int size,String table,String admin) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("size", size);
		map.put("table", table);
		map.put("admin", admin);
		return sqlSession.selectList(NAMESPACE + SELECTREPORTS,map);
	}
	
	public long countReports(String table,String admin) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("table", table);
		map.put("admin", admin);
		return sqlSession.selectOne(NAMESPACE + COUNTREPORTS,map);
	}
	
	public void updateReports(Report r,String table) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", r.getId());
		map.put("state", r.getState());
		map.put("table", table);
		sqlSession.update(NAMESPACE + UPDATEREPORTBYID,map);
	}

}
