package com.lhdx.www.server.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lhdx.www.server.model.Report;
import com.lhdx.www.server.model.User;

@Component("reportDao")
public class ReportDao extends BaseDao {
	private static final String NAMESPACE = "com.lhdx.www.server.dao.ReportDao";
	private static final String SELECTREPORTS = ".selectReports";
	private static final String COUNTREPORTS = ".countReports";
	private static final String UPDATEREPORTBYID = ".updateReportById";
	private static final String BATCHUPDATEREPORTWITHMAP =".batchUpdateReportWithMap";
	private static final String CREATETABLEBYNAME =".createTableByName";
	private static final String BATCHADDREPORTS =".batchAddReports";

	public List<Report> selectReports(int start,int size,String table,User user,String isSend) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("size", size);
		map.put("table", table);
		map.put("user", user);
		map.put("isSend", isSend);
		return sqlSession.selectList(NAMESPACE + SELECTREPORTS,map);
	}
	
	public long countReports(String table,User user,String isSend) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("table", table);
		map.put("user", user);
		map.put("isSend", isSend);
		return sqlSession.selectOne(NAMESPACE + COUNTREPORTS,map);
	}
	
	public void updateReports(Report r,String table) {
		Timestamp stateDate = new Timestamp(new Date().getTime());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", r.getId());
		map.put("state", r.getState());
		map.put("remark", r.getRemark());
		map.put("table", table);
		map.put("stateDate", stateDate);
		sqlSession.update(NAMESPACE + UPDATEREPORTBYID,map);
	}
	
	public void batchUpdateStudentWithMap(String[] ids,String table,User user){  
	    Map<String,Object> map = new HashMap<String,Object>();  
	    map.put("idList", ids);  
	    map.put("table", table);  
	    map.put("user", user);
	    sqlSession.insert(NAMESPACE+BATCHUPDATEREPORTWITHMAP,map);  
	}  

	public void createReports(String table) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("table", table);
		sqlSession.update(NAMESPACE + CREATETABLEBYNAME,map);
	}

	public void batchUpdateReports(List<Report> reports,String table){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("table", table);
		map.put("reports", reports);
		sqlSession.update(NAMESPACE + BATCHADDREPORTS,map);
	}
}
