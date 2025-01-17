package com.groupone.shazar.service;

import com.groupone.shazar.model.User;

public interface UserService {

	User getCurrentUser(String username);
	
	User updateUser(User user);
	
}
