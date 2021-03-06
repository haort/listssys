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
	private static final String SELECTUSERBYID = ".selectUserById";
	private static final String SELECTUSERBYPARENTID = ".selectUserByParentId";
	private static final String SELECTADMINIUSER = ".selectAdminUser";
	private static final String SELECTADMINTREENODEBYPARENTID = ".selectAdminTreeNodeByParentId";
	private static final String UPDATEUSERPARENTID = ".updateUserParentId";
	private static final String UPDATEUSEBYID = ".updateUserById";
	private static final String ADDUSER = ".addUser";
	private static final String DELETEUSERBYID = ".deleteUserById";
	
	public User selectuUserByNameAndPwd(String userName,String pwd) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", userName);
		map.put("pwd", pwd);
		return sqlSession.selectOne(NAMESPACE + SELECTUSERBYNAMEANDPWD,map);
	}
	
	public User selectuUserById(int uid) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		return sqlSession.selectOne(NAMESPACE + SELECTUSERBYID,map);
	}
	
	public List<User> selectuUserByParentId(int parentId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parentId", parentId);
		return sqlSession.selectList(NAMESPACE + SELECTUSERBYPARENTID,map);
	}
	
	public User selectuAdminUser() {
		return sqlSession.selectOne(NAMESPACE + SELECTADMINIUSER);
	}
	
	public List<AdminTree> selectAdminTreeNodeByParentId(int uid) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		return sqlSession.selectList(NAMESPACE + SELECTADMINTREENODEBYPARENTID,map);
	}
	
	public void updateUserParentId(int uid,int parentId,int deep){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		map.put("parentId", parentId);
		map.put("deep", deep);
		sqlSession.update(NAMESPACE+UPDATEUSERPARENTID, map);
	}
	
	public void updateUserById(User u){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user", u);
		sqlSession.update(NAMESPACE+UPDATEUSEBYID, map);
	}
	
	public void addUser(User u){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user", u);
		sqlSession.insert(NAMESPACE+ADDUSER, map);
	}
	
	public void deleteUserById(int uid){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		sqlSession.delete(NAMESPACE+DELETEUSERBYID, map);
	}
	
}
