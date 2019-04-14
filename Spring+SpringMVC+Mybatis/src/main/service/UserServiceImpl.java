package main.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.mapper.UserMapper;
import main.pojo.User;

@Service	
public class UserServiceImpl implements UserService{

	
    public UserMapper userMapper;

	public List<User> selectByPrimaryKey() throws Exception {
		// TODO Auto-generated method stub
			List<User> selectByPrimaryKey=userMapper.findAll();
				return selectByPrimaryKey;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User find(int id) {
		return null;
	}
//	public List<User> findAll() throws Exception {
//		// TODO Auto-generated method stub
//		List<User> selectByPrimaryKey=userMapper.findAll();
//		return selectByPrimaryKey;
//	}

}
