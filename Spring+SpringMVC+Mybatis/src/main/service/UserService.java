package main.service;



import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import main.mapper.UserMapper;
import main.pojo.User;

@Repository
public interface UserService{

	List<User> selectByPrimaryKey() throws Exception;
}
