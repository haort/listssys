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

	public List<Report> selectReports(int start,int size,String record) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("size", size);
		map.put("table", record);
		return sqlSession.selectList(NAMESPACE + SELECTREPORTS,map);
	}
	
	public long countReports(String record) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("table", record);
		return sqlSession.selectOne(NAMESPACE + COUNTREPORTS,map);
	}

}
