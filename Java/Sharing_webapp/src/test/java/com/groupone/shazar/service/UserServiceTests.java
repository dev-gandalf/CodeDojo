package com.groupone.shazar.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.groupone.shazar.model.User;
import com.groupone.shazar.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTests {
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@BeforeEach
	void setUp() throws Exception{
		
	}
	
	@Test
	void whenGetCurrentUser() {
		userService.getCurrentUser("test");
		verify(userRepository, times(1)).findByUsername(Mockito.anyString());
	}
	
	@Test
	void whenUpdateUser() {
		User user = new User();
		user.setCityName("Frankfurt");
		user.setCountry("Germany");
		user.setFirstName("Matt");
		user.setLastName("Last");
		user.setStreetName("ScheeneStr");
		user.setEmail("You@you.com");
		user.setZipCode("112233");
		
		userService.updateUser(user);
		verify(userRepository, times(1)).save(Mockito.any(User.class));
	}
	
}
