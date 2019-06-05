package com.giit.www.system.service.impl;

import com.giit.www.entity.Role;
import com.giit.www.system.dao.RoleDao;
import com.giit.www.system.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;
    public Role findOne(Long id){
        return roleDao.findOne(id);
    }
    public Set<String> findRoles(Long...id){
        Set<String> roles=new HashSet<String>();
        for(Long roleid:id){
            Role role=findOne(roleid);
            if(role!=null){
                roles.add(role.getRole());
            }
        }
        return roles;
    }

}
