package com.sxl.dao;

import java.util.List;
import com.sxl.model.User;


public interface UserDao {
	
	List<User> queryForList(User user);

	int delete(Integer id);

	User getById(Integer id);

	int update(User user);

	int insert(User user);
}
