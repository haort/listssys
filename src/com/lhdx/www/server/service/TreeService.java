package com.lhdx.www.server.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lhdx.www.server.dao.TreeDao;
import com.lhdx.www.server.model.Tree;


@Service("treeService")
public class TreeService {
	@Resource(name="treeDao")
	private TreeDao treeDao;
	
	public Map<String,Object> findTree(){
		 List<Tree> list = treeDao.selectTreeNode();
		 if(list!=null&&list.size()!=0){
			 Iterator<Tree> i = list.iterator();
			 while(i.hasNext()){
				 Tree t = i.next();
				 List<Tree> childrens = treeDao.selectTreeNodeByParentId(t.getNid());
				 t.setChildren(childrens);
			 }
		 }
		 Tree root = new Tree();
		 root.setId("root");
		 root.setLeaf(false);
		 root.setText("总清单");
		 root.setChildren(list);
		 Map<String,Object> map = new HashMap<String,Object>();  
	     map.put("children", root);  
		return map;
	}
}
