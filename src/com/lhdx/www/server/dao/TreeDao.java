package com.lhdx.www.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lhdx.www.server.model.Tree;

@Component("treeDao")
public class TreeDao extends BaseDao {
	private static final String NAMESPACE = "com.lhdx.www.server.dao.TreeDao";
	private static final String SELECTTREENODE = ".selectTreeNode";
	private static final String SELECTTREENODEBYPARENTID = ".selectTreeNodeByParentId";
	private static final String ADDTREE = ".addTree";
	private static final String SELECTTREEBYNAME = ".selectTreeByName";

	
	public List<Tree> selectTreeNode() {
		return sqlSession.selectList(NAMESPACE + SELECTTREENODE);
	}

	public List<Tree> selectTreeNodeByParentId(int nid) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("nid", nid);
		return sqlSession.selectList(NAMESPACE + SELECTTREENODEBYPARENTID,map);
	}

	public void addTree(Tree tree){
		sqlSession.insert(NAMESPACE+ADDTREE, tree);
	}
	
	public Tree findByName(String name){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		return sqlSession.selectOne(NAMESPACE + SELECTTREEBYNAME,map);
	}
}
