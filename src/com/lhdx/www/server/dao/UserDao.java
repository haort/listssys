package com.lhdx.www.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lhdx.www.server.model.AdminTree;
import com.lhdx.www.server.model.User;

@Component("userDao")
public class UserDao extends BaseDao {
	private static final String NAMESPACE = "com.lhdx.www.server.dao.UserDao";
	private static final String SELECTUSERBYNAMEANDPWD = ".selectUserByNameAndPwd";
	private static final String SELECTADMINTREENODEBYPARENTID = ".selectAdminTreeNodeByParentId";
	
	public User selectuUserByNameAndPwd(String userName,String pwd) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", userName);
		map.put("pwd", pwd);
		return sqlSession.selectOne(NAMESPACE + SELECTUSERBYNAMEANDPWD,map);
	}
	
	
	public List<AdminTree> selectAdminTreeNodeByParentId(int uid) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		return sqlSession.selectList(NAMESPACE + SELECTADMINTREENODEBYPARENTID,map);
	}
}
