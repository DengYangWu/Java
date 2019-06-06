package com.giit.www.system.service.impl;

import com.giit.www.entity.Role;
import com.giit.www.entity.User;
import com.giit.www.system.dao.RoleDao;
import com.giit.www.system.dao.UserDao;
import com.giit.www.system.service.RoleService;
import com.giit.www.system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private RoleService roleService;
    public User findName(String name){
        return userDao.findName(name);
    }
    public Set<String> findRoles(String username){
        User user=userDao.findName(username);
//        if(user==null){
//            return Collections.EMPTY_SET;
//        }

        return roleService.findRoles(user.getRoleIds());

    }
    public Set<String> findPermissions(String name){
        User user=userDao.findName(name);
        if(user==null){
            return Collections.EMPTY_SET;
        }

        return roleService.findRoles(user.getRoleIds());
    }
}
