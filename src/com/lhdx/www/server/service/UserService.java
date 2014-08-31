package com.lhdx.www.server.service;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.lhdx.www.server.dao.UserDao;
import com.lhdx.www.server.model.AdminTree;
import com.lhdx.www.server.model.User;

@Service("userService")
public class UserService {
	@Resource(name = "userDao")
	private UserDao userDao;

	public User findUserByNameAndPwd(String name, String pwd) {
		return userDao.selectuUserByNameAndPwd(name, pwd);
	}

	public List<AdminTree> findAdminTreeByParentId(int uid) {
		return userDao.selectAdminTreeNodeByParentId(uid);
	}

	public User findUsersByParentId(User u) {
		convertToTree(u);
		return findUsers(u);
	}

	public User findUsers(User user) {
		while (user != null) {
			List<User> us = userDao.selectuUserByParentId(user.getUid());
			Iterator<User> i = us.iterator();
			while (i.hasNext()) {
				User u = i.next();
				convertToTree(u);
			}
			user.setChildren(us);
			Iterator<User> it = us.iterator();
			while (it.hasNext()) {
				User u = it.next();
				findUsers(u);
			}
			break;
		}
		return user;
	}

	private User convertToTree(User u) {
		u.setText(u.getName());
		String qtip = "";
		if (u.getDepartMent() != null && !"".equals(u.getDepartMent())) {
			qtip += "部门：" + u.getDepartMent() + "<br/>";
		}
		if (u.getArea() != null && !"".equals(u.getArea())) {
			qtip += "区域：" + u.getArea() + "<br/>";
		}
		if (u.getChName() != null && !"".equals(u.getChName())) {
			qtip += "营业厅：" + u.getChName() + "<br/>";
		}
		u.setQtip(qtip);
		u.setIconCls("user");
		return u;
	}

	public void updateUserParentId(int uid, int parentId, int deep) {
		userDao.updateUserParentId(uid, parentId, deep);

	}

	public void updateOrAddUser(User u, String uid, String userName,
			String password, String name, String departMent, String area,
			String chName, String authority) {
		User user = new User();
		user.setArea(area);
		user.setAuthority(authority);
		user.setChName(chName);
		user.setDepartMent(departMent);
		user.setName(name);
		user.setPassword(password);
		user.setUserName(userName);
		if (uid != null && !"".equals(uid)) {
			user.setUid(Integer.parseInt(uid));
			userDao.updateUserById(user);
		}else{
			user.setDeep(u.getDeep() + 1);
			user.setParentid(u.getUid());
			userDao.addUser(user);
		}

	}
	
	public void deleteUserById(int uid){
		userDao.deleteUserById(uid);
	}
}
