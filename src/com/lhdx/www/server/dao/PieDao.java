package com.lhdx.www.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lhdx.www.server.model.User;

@Component("pieDao")
public class PieDao extends BaseDao {
	private static final String NAMESPACE = "com.lhdx.www.server.dao.PieDao";
	private static final String SELECTPIEBYTABLE = ".selectPieByTable";

	public List selectPieByTable(String table,User user) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("table", table);
		map.put("user", user);
		return sqlSession.selectList(NAMESPACE + SELECTPIEBYTABLE,map);
	}
}
