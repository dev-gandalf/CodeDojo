package com.groupone.shazar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupone.shazar.model.User;
import com.groupone.shazar.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository repo;

	@Autowired
	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}


	@Override
	public User getCurrentUser(String username) {
		Optional<User> currentUser = repo.findByUsername(username);
		return currentUser.orElse(null);
	}

	@Override
	public User updateUser(User user) {
		Optional<User> outputUser = repo.findByUsername(user.getUsername());
		User updatedUser = outputUser.orElse(new User());
		updatedUser.setCityName(user.getCityName());
		updatedUser.setCountry(user.getCountry());
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setStreetName(user.getStreetName());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setZipCode(user.getZipCode());
		return repo.save(updatedUser);
	}



}
