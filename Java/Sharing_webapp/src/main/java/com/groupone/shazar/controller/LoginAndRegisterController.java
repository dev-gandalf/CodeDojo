package com.groupone.shazar.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupone.shazar.model.Role;
import com.groupone.shazar.model.User;
import com.groupone.shazar.security.DefaultUserDetailsService;
import com.groupone.shazar.service.RoleService;



@Controller
public class LoginAndRegisterController {

	@Autowired
	private DefaultUserDetailsService userService;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private RoleService roleService;


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/registration")
	public String register() {
		return "registration";
	}

	@PostMapping("/registration")
	public String registerSubmit(@RequestParam String passwordConfirmed, @ModelAttribute("user")User user, ModelMap model) {
		Optional<User> userFromDatabase = userService.findByUsername(user.getUsername());
		Optional<User> emailFromDatabase = userService.findByEmail(user.getEmail());
		if (userFromDatabase.isPresent()) {
			model.addAttribute("userNameMessage", "This user name already exists");
			return "registration";
		}

		if (emailFromDatabase.isPresent()) {
			model.addAttribute("emailMessage", "This email already exists");
			return "registration";

		}

		if (!(user.getPassword().equals(passwordConfirmed))) {
			model.addAttribute("passwordMessage", "Passwords don't match");
			return "registration";


		}
		user.setRole(new Role("customer"));
		user.setPassword(encoder.encode(user.getPassword()));
		userService.save(user);

		return "login";
	}
}
