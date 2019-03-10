package main.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import main.pojo.User;
@Repository
public interface UserMapper {
     List<User> findAll() throws Exception;
}
