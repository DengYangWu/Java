package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.entity.User;

public interface UserService {
	User getUserByName(String username);
	List<User> getList();
}
