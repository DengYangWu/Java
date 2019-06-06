package com.giit.www.system.service;

import com.giit.www.entity.Role;

import java.util.Set;

public interface RoleService {
    Role findOne(Long id);
    Set<String> findRoles(Long... roleIds);
}
