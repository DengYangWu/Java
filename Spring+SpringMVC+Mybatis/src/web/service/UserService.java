package web.service;



import java.util.List;

import org.springframework.stereotype.Service;


import web.pojo.User;

@Service(value = "UserService")
public abstract class UserService{


	/*
	 * 通过id获取数据
	 * */
	public abstract List<User> selectByPrimaryKey() throws Exception;
}
