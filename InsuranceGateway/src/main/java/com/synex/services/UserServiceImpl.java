package com.synex.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synex.domain.User;
import com.synex.repository.UserRepository;


@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User save(User u) {
		String password = passwordEncoder.encode(u.getUserPassword());
		u.setUserPassword(password);
		//System.out.println("hi this is user save (user u): " + u);
		User user = repository.save(u);
		return user;
	}
	@Override
	public User save2(User u) {
		User user = repository.save(u);
		return user;
	}

	@Override
	public void deleteUserById(long userId) {
		repository.deleteById(userId);
	}

	@Override
	public User findByUserId(long userId) {
		Optional<User> user = repository.findById(userId);
		if (user.isPresent())
			return user.get();
		return null;
	}

	@Override
	public User findByUserName(String userName) {
		return repository.findByUserName(userName);
	}

}
