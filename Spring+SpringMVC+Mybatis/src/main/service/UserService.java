package main.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import main.dao.UserMapper;
import main.pojo.User;

public interface UserService{

	//public List<User> selectUser() throws Exception {
//		// TODO Auto-generated method stub
//		List<User> selectByPrimaryKey=userMapper.findAll();
//		for(int i=0;i<selectByPrimaryKey.size();i++)
//		{
//		    User user = selectByPrimaryKey.get(i);
//		    System.out.println(user.getId());
//		}
//				return selectByPrimaryKey;
//	}


	List<User> findAll();
	User find(int id);
}
