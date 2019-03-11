package main.dao;


import java.util.List;



import main.pojo.User;

public interface UserMapper {
	List<User> findAll();
	User find(int id);

}
