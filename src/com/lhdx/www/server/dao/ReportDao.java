package com.lhdx.www.server.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.lhdx.www.server.model.Report;

@Component("reportDao")
public class ReportDao extends BaseDao {
	private static final String NAMESPACE = "com.lhdx.www.server.dao.ReportDao";
	private static final String SELECTREPORTS = ".selectReports";

	public List<Report> selectReports() {
		return sqlSession.selectList(NAMESPACE + SELECTREPORTS);
	}

}
