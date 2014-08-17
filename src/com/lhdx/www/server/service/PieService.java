package com.lhdx.www.server.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lhdx.www.server.dao.PieDao;
import com.lhdx.www.server.model.Tree;


@Service("pieService")
public class PieService {
	@Resource(name="pieDao")
	private PieDao pieDao;
	
	public List findPie(String table){
		return pieDao.selectPieByTable(table);
	}
}
