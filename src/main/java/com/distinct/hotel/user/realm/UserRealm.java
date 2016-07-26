package com.distinct.hotel.user.realm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.distinct.hotel.user.model.Role;
import com.distinct.hotel.user.model.User;
import com.distinct.hotel.user.service.UserService;

public class UserRealm extends AuthorizingRealm {
	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String account = (String)super.getAvailablePrincipal(principals);
		List<String> roles = new ArrayList<String>();
		List<Role> roleList = userService.getRoleByAccount(account);
		if(null != roleList && roleList.size() > 0){
			for(Role role : roleList){
				roles.add(role.getRoleName());
			}
		}
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		simpleAuthorInfo.addRoles(roles);
		return simpleAuthorInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		User user = userService.getUserByAccount(token.getUsername());
		if(null != user){
			AuthenticationInfo authInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPwd(), user.getCompany());
			this.setSession("currentUser", user);
			return authInfo;
		}
		return null;
	}
	
	private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){  
            Session session = currentUser.getSession();  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    } 

}
