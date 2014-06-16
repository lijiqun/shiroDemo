package cn.ssms.dao;

import java.util.List;

import cn.ssms.model.Role;


public interface RoleMapper {
    public List<Role> queryUserRoleList(String name);
}