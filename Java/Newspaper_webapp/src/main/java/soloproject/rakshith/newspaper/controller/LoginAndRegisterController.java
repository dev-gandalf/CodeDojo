package soloproject.rakshith.newspaper.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import soloproject.rakshith.newspaper.model.Category;
import soloproject.rakshith.newspaper.model.EndUser;
import soloproject.rakshith.newspaper.security.DefaultUserDetailsService;
import soloproject.rakshith.newspaper.service.CategoryService;
import soloproject.rakshith.newspaper.service.RoleService;



@Controller
public class LoginAndRegisterController {

	@Autowired
	private DefaultUserDetailsService userService;
	
	@Autowired private CategoryService categoryService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Autowired
	private RoleService roleService;
	

	
	@GetMapping("/login")
	public String login(ModelMap model) {
		Optional<EndUser> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Category> category = categoryService.getAllCategories();
		model.addAttribute("category", category);
		model.addAttribute("user", user);
		return "login";
	}
	
	@GetMapping("/register")
	public String register(ModelMap model) {
		Optional<EndUser> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Category> category = categoryService.getAllCategories();
		model.addAttribute("category", category);
		model.addAttribute("user", user);
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerSubmit(@ModelAttribute("user")EndUser user, ModelMap model) {
		Optional<EndUser> userFromDatabase = userService.findByUsername(user.getUsername());
		if (userFromDatabase.isPresent()) {
			model.addAttribute("message", "This user name already exists");
			return "register";
		}
		
		user.setRole(roleService.findByRoleName("Customer"));
		user.setPassword(encoder.encode(user.getPassword()));
		userService.save(user);
		model.addAttribute("user", "This user name already exists");
		return "redirect:/index";
	}
}
