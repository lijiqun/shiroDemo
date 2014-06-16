package cn.ssms.service;

import java.util.List;

import cn.ssms.model.Role;

public interface RoleService {
	public List<Role> queryUserRoleList(String name);
}
