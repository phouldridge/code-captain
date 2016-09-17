package com.northbender.services;

import com.northbender.domain.User;

public interface UserService {
	Iterable<User> listAll();
	User getUserById( Integer Id);
	User saveUser( User user);
	void deleteUser( Integer Id);
}
