package mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.User;
@Repository
public interface UserMapper {
	public List<User> selectByPrimaryKey() throws Exception;
}
