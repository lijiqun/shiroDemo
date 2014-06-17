package cn.ssms.dao;

import java.util.List;

import cn.ssms.model.Permission;
import cn.ssms.model.Role;

/**
	author:lijiqun
	date:2014年6月17日 上午11:00:44 
 */
public interface PermissionMapper {
	
	public List<Permission> queryRolePermissionList(List<Role> roleIds);
	
	
	public void insertPermission(Permission permission);
}
