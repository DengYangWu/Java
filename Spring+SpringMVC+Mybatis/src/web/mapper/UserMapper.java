package web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import web.pojo.User;
@Repository
public interface UserMapper {
	 List<User> selectByPrimaryKey() throws Exception;
}
