package com.binmaa.mapper;

import java.util.List;

import com.binmaa.pojo.QueryVo;
import com.binmaa.pojo.User;

public interface UserMapper {
	public User getUserByID(int id);
	public List<User> getUserByQueryVo(QueryVo queruVo);
	List<User> getUserByUser(User user);
	List<User> getUserByIds(List<Integer> Ids);
	List<User> getUserOrders();
}
