package com.synex.services;

import java.util.List;

import com.synex.domain.User;



public interface UserService {
	public List<User> findAll();
	public User save(User u);
	public User save2(User u);
	public void deleteUserById(long userId);
	public User findByUserId(long userId);
	public User findByUserName(String userName);
}
