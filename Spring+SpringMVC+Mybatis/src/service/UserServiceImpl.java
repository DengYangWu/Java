package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mapper.UserMapper;
import pojo.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Resource
    public UserMapper userMapper;
	public List<User> selectByPrimaryKey() throws Exception {
		// TODO Auto-generated method stub
			List<User> selectByPrimaryKey=userMapper.selectByPrimaryKey();
				return selectByPrimaryKey;
	}

}
