package com.groupone.shazar.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupone.shazar.model.User;
import com.groupone.shazar.service.UserService;

@Controller
public class ProfileController{
	private UserService userService;

	@Autowired
	public ProfileController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/profile")
	public String goToProfile(ModelMap model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();


		model.addAttribute("user", userService.getCurrentUser(username));
		return "profile";
	}

	@PostMapping("/profile")
	public String updateProfile(ModelMap model, @ModelAttribute("user")User user){
		model.addAttribute("user", userService.updateUser(user));
		return "profile";
	}
}