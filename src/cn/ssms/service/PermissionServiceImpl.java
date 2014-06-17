package cn.ssms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ssms.dao.PermissionMapper;
import cn.ssms.dao.RoleMapper;
import cn.ssms.dao.RolePermissionMapper;
import cn.ssms.model.Permission;
import cn.ssms.model.Role;
import cn.ssms.model.RolePermission;

/**
	author:lijiqun
	date:2014年6月17日 上午11:04:48 
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
	
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	@Override
	public List<Permission> queryRolePermissionList(String name) {
		//查询所有角色
		List<Role> roleIds = this.roleMapper.queryUserRoleList(name);
		List<Permission> permissions = this.permissionMapper.queryRolePermissionList(roleIds);
		return permissions;
	}

	@Override
	public void insertPermission() {
		/*for(int i=28;i<1029;i++){
			String code = "user:create"+i;
			String name = "插入操作"+i;
			Permission permission = new Permission();
			permission.setId(null);
			permission.setCode(code);
			permission.setName(name);
			System.out.println(permission.toString());
			this.permissionMapper.insertPermission(permission);
			int permissionId = permission.getId();
			int roleId = 1;
			RolePermission rp = new RolePermission();
			rp.setPermissionId(i);
			rp.setRoleId(roleId);
			this.rolePermissionMapper.insertRolePermission(rp);
			System.out.println(rp.toString());
			System.out.println(":::::::::::::::::::::::::"+permissionId);
			System.out.println(permission.toString());
		}*/
	}

}
