package cn.ssms.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ssms.model.Permission;
import cn.ssms.model.Role;
import cn.ssms.model.User;
import cn.ssms.service.PermissionService;
import cn.ssms.service.RoleService;
import cn.ssms.service.UserService;

public class ShiroDbRealm extends AuthorizingRealm {
	private static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);
	private static final String ALGORITHM = "MD5";
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	public ShiroDbRealm() {
		super();
	}
	
	/**
	 * 认证回调函数, 登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		System.out.println(token.getUsername()+":::::");
		User user = userService.findUserByLoginName(token.getUsername());
		System.out.println(user);
		if (user != null) {
			System.out.println("coming............");
			return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
		}else{
			throw new AuthenticationException();
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/* 这里编写授权代码 */
		String loginName = (String) principals.fromRealm(getName()).iterator().next();//获取登陆的用户名
		List<Role> Roles = this.roleService.queryUserRoleList(loginName);
		List<Permission> permissions = this.permissionService.queryRolePermissionList(loginName);
		this.permissionService.insertPermission();
		Set<String> roleNames = new HashSet<String>();//角色集合
		for(Role role:Roles){
			roleNames.add(role.getCode());
		}
	   Set<String> perms = new HashSet<String>();//权限集合
	    for(Permission per:permissions){
	    	perms.add(per.getCode());
	    }
	    System.out.println("角色列表："+Roles.toString());
	    System.out.println("总共权限有： "+perms.size());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		info.setStringPermissions(perms);
		return info;
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

//	@PostConstruct
//	public void initCredentialsMatcher() {//MD5加密
//		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(ALGORITHM);
//		setCredentialsMatcher(matcher);
//	}
}
