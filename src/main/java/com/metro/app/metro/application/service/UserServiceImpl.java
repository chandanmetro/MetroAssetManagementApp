package com.metro.app.metro.application.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.metro.app.metro.application.entity.User;
import com.metro.app.metro.application.repository.UserRepository;

public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public User saveUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);

	}

}
