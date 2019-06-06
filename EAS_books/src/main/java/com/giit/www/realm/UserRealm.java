package com.giit.www.realm;

import com.giit.www.entity.Role;
import com.giit.www.entity.User;
import com.giit.www.system.service.RoleService;
import com.giit.www.system.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.security.sasl.AuthorizeCallback;
import java.util.HashSet;
import java.util.Set;

//根据身份获取验证信息
@Component
public class UserRealm extends AuthorizingRealm{
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        // TODO Auto-generated method stub
        String username = (String) getAvailablePrincipal(principals);

        Role role = null;

        try {
            User  user = userService.findName(username);
            //??????????
            role = roleService.findOne(user.getRoleIds());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //????????????????????/??????
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<String>();
        if (role != null) {
            r.add(role.getRole());
            info.setRoles(r);
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        // TODO Auto-generated method stub
        String username = (String) token.getPrincipal();
        // 调用userService查询是否有此用户
        User user = userService.findName(username);
        if (user == null) {
            // 抛出 帐号找不到异常
            throw new UnknownAccountException();
        }
        // 判断帐号是否锁定
        if (Boolean.TRUE.equals(user.getLocked())) {
            // 抛出 帐号锁定异常
            throw new LockedAccountException();
        }

        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), // 用户名
                user.getPassword(), // 密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),// salt=username+salt
                getName() // realm name
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
