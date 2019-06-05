package com.giit.www.system.service;

import java.util.Set;

public interface RoleService {
    Set<String> findRoles(Long... roleIds);
}
