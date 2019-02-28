package service;



import java.util.List;

import org.springframework.stereotype.Service;


import mapper.UserMapper;
import pojo.User;

@Service("UserService")
public interface UserService{


	/*
	 * 通过id获取数据
	 * */
	public List<User> selectByPrimaryKey() throws Exception;
}
