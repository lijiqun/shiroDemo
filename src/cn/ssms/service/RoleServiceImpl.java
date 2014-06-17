package cn.ssms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ssms.dao.RoleMapper;
import cn.ssms.model.Role;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> queryUserRoleList(String name) {
		return this.roleMapper.queryUserRoleList(name);
	}


}
