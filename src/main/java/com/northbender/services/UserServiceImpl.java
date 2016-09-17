package com.northbender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northbender.domain.User;
import com.northbender.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
	public Iterable<User> listAll() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer Id) {
		return userRepository.findOne(Id);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Integer Id) {
		userRepository.delete(Id);
	}
}