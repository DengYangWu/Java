package web.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.mapper.UserMapper;
import web.pojo.User;

@Service
public class UserServiceImpl extends UserService {
	@Autowired
    public UserMapper userMapper;
	@Transactional
	public List<User> selectByPrimaryKey() throws Exception {
		// TODO Auto-generated method stub
			List<User> selectByPrimaryKey=userMapper.selectByPrimaryKey();
				return selectByPrimaryKey;
	}

}
