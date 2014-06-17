package cn.ssms.service;

import java.util.List;

import cn.ssms.model.Permission;

/**
	author:lijiqun
	date:2014年6月17日 上午11:02:04 
 */
public interface PermissionService {
	
	public List<Permission> queryRolePermissionList(String name);
	
	public void insertPermission();
}
