package service;



import java.util.List;

import org.springframework.stereotype.Service;


import mapper.UserMapper;
import pojo.User;

@Service("UserService")
public interface UserService{


	/*
	 * ͨ��id��ȡ����
	 * */
	public List<User> selectByPrimaryKey() throws Exception;
}
