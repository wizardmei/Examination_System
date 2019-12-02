package com.system.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.mapper.RoleMapper;
import com.system.mapper.UserLoginMapper;
import com.system.po.Role;
import com.system.po.UserLogin;

@Component
public class LoginRealm extends AuthorizingRealm{
	
	@Autowired
	private UserLoginMapper userLoginMapper;
	
	@Autowired
	private RoleMapper rolemapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		String username = (String) getAvailablePrincipal(principalCollection);
		UserLogin userlogin = userLoginMapper.findByName(username);
		Role role = rolemapper.findById(userlogin.getRole());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> r = new HashSet<String>();
		if(role != null) {
			r.add(role.getRoleName());
			info.setRoles(r);
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String)token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		if(userLoginMapper.findByName(username) == null) {
			throw new UnknownAccountException();
		}
		if(userLoginMapper.selectByUserName(username, password) == null) {
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(username,password,getName());
	}
}
