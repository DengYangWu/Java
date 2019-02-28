package service;



import java.util.List;

import org.springframework.stereotype.Service;


import mapper.UserMapper;
import pojo.User;

@Service("UserService")
public class UserService implements UserMapper{
	//@Resource(name="UserMapper")
	private UserMapper dao;
	public UserMapper getDao() {
		return dao;
	}
	public void setDao(UserMapper dao) {
		this.dao = dao;
	}
	/*
	 * 通过id获取数据
	 * */
	public List<User> selectByPrimaryKey() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey();
	}
}
