package main.service.servicelmpl;



import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.dao.UserMapper;
import main.pojo.User;
import main.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserMapper userMapper;
	
//	public List<User> findAll() throws Exception {
//		// TODO Auto-generated method stub
//		List<User> selectByPrimaryKey=userMapper.findAll();
//		return selectByPrimaryKey;
//	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}


	public User find(int id){
		// TODO Auto-generated method stub
		return userMapper.find(id);
	}

}
