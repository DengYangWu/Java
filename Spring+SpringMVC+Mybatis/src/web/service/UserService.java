package web.service;



import java.util.List;

import org.springframework.stereotype.Service;


import web.pojo.User;

@Service(value = "UserService")
public abstract class UserService{


	/*
	 * ͨ��id��ȡ����
	 * */
	public abstract List<User> selectByPrimaryKey() throws Exception;
}
