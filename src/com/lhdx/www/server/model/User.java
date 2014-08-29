package com.lhdx.www.server.model;

import java.util.ArrayList;
import java.util.List;

public class User implements java.io.Serializable{
	private static final long serialVersionUID = -8567939671669205177L;
	private String userName;
	private int uid;
	private String password;
	private String authority;
	private String departMent;
	private String area;
	private int deep;
	private String chName;
	private List<User> children = new ArrayList<User>();
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getDepartMent() {
		return departMent;
	}
	public void setDepartMent(String departMent) {
		this.departMent = departMent;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getDeep() {
		return deep;
	}
	public void setDeep(int deep) {
		this.deep = deep;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public List<User> getChildren() {
		return children;
	}
	public void setChildren(List<User> children) {
		this.children = children;
	}
	
}
