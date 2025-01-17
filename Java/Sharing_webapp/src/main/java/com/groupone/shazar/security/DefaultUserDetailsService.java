package com.groupone.shazar.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.groupone.shazar.model.User;
import com.groupone.shazar.repository.UserRepository;


@Service
public class DefaultUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		return new UserPrincipal(user);
	}
	
	public Optional<User> findByUsername(String username){
		return repository.findByUsername(username);
	}
	
	public Optional<User> findByEmail(String email){
		return repository.findByEmail(email);
	}
	
	public User save(User user) {
		return repository.save(user);
	}

}
