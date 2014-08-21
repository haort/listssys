package com.lhdx.www.server.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lhdx.www.server.dao.UserDao;
import com.lhdx.www.server.model.AdminTree;
import com.lhdx.www.server.model.User;


@Service("userService")
public class UserService {
	@Resource(name="userDao")
	private UserDao userDao;
	
	public User findUserByNameAndPwd(String name,String pwd){
		return userDao.selectuUserByNameAndPwd(name, pwd);
	}
	
	public List<AdminTree> findAdminTreeByParentId(int uid){
		return userDao.selectAdminTreeNodeByParentId(uid);
	}
}
