package com.lhdx.www.server.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lhdx.www.server.dao.PieDao;
import com.lhdx.www.server.model.User;


@Service("pieService")
public class PieService {
	@Resource(name="pieDao")
	private PieDao pieDao;
	
	public List findPie(String table,User user){
		return pieDao.selectPieByTable(table,user);
	}
}
