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
    public User findId(String id){
        return userDao.findId(id);
    }
    public Set<String> findRoles(String username){
        User user=userDao.findId(username);
        if(user==null){
            return Collections.EMPTY_SET;
        }

        return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));

    }
}
