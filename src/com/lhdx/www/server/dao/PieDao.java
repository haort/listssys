package com.lhdx.www.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lhdx.www.server.model.Tree;

@Component("pieDao")
public class PieDao extends BaseDao {
	private static final String NAMESPACE = "com.lhdx.www.server.dao.PieDao";
	private static final String SELECTPIEBYTABLE = ".selectPieByTable";

	public List selectPieByTable(String table) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("table", table);
		return sqlSession.selectList(NAMESPACE + SELECTPIEBYTABLE,map);
	}
}
