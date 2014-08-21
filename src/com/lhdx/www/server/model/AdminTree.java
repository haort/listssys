package com.lhdx.www.server.model;

import java.util.ArrayList;
import java.util.List;

public class AdminTree {
	private String id;
	private String text;
	private boolean leaf=true;
	private List<AdminTree> children = new ArrayList<AdminTree>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public List<AdminTree> getChildren() {
		return children;
	}
	public void setChildren(List<AdminTree> children) {
		this.children = children;
	}
	
}
