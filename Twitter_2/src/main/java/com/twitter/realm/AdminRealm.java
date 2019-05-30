package com.twitter.realm;

import com.twitter.pojo.Admins;
import com.twitter.servlet.AdminsService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Component
public class AdminRealm extends AuthorizingRealm {
    @Resource(name = "adminsServiceImpl")
    private AdminsService adminsService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username=(String)getAvailablePrincipal(principals);
        Admins admins=null;
        try{
            admins.setAname(username);
            admins=adminsService.findById(admins);
        }catch (Exception e){
            e.printStackTrace();
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> strings=new HashSet<String>();
        if(admins!=null){
            strings.add(admins.getAname());
            info.setRoles(strings);
        }
        return info;
    }
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //?????
        String username = (String) token.getPrincipal();
        //????
        String password = new String((char[])token.getCredentials());

        Admins admins=null;
        try{
            admins.setAname(username);
            admins=adminsService.findById(admins);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (admins == null) {
            //?????????
            throw new UnknownAccountException();
        } else if (!password.equals(admins.getApwd())) {
            //???????
            throw new IncorrectCredentialsException();
        }

        //?????????,?????????????
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());

        return aInfo;
    }

}
