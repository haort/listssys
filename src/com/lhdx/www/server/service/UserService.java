package com.lhdx.www.server.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lhdx.www.server.dao.UserDao;
import com.lhdx.www.server.model.User;


@Service("userService")
public class UserService {
	@Resource(name="userDao")
	private UserDao userDao;
	
	public User findUserByNameAndPwd(String name,String pwd){
		return userDao.selectuUserByNameAndPwd(name, pwd);
	}
}
