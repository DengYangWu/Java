package com.giit.www.system.service;

import com.giit.www.entity.User;

import java.util.Set;

public interface UserService {
    User findName(String name);
    int findNameById(String name);
}
