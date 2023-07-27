package com.metro.app.metro.application.service;

import com.metro.app.metro.application.entity.User;

public interface UserService {
	User findByUsername(String username);

	User saveUser(User user);

    void deleteUser(Long userId);

}
