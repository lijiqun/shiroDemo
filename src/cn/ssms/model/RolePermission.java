package cn.ssms.model;

import java.io.Serializable;

/**
	author:lijiqun
	date:2014年6月17日 下午3:30:26 
 */
public class RolePermission implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2557015493496826176L;
	private int id;
	private int roleId;
	private int permissionId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	@Override
	public String toString() {
		return "RolePermission [id=" + id + ", roleId=" + roleId
				+ ", permissionId=" + permissionId + "]";
	}
	
	
}
