package soloproject.rakshith.newspaper.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import soloproject.rakshith.newspaper.model.Articles;
import soloproject.rakshith.newspaper.model.Role;
import soloproject.rakshith.newspaper.model.EndUser;
import soloproject.rakshith.newspaper.security.DefaultUserDetailsService;
import soloproject.rakshith.newspaper.service.ArticleService;
import soloproject.rakshith.newspaper.service.CategoryService;
import soloproject.rakshith.newspaper.service.RoleService;



@Controller
public class AdminController {

	@Autowired
	ArticleService articleService;
	@Autowired
	DefaultUserDetailsService userService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private RoleService roleService;
	

	@GetMapping("/deleteArticles")
	public String Articles(ModelMap model) {
		Optional<EndUser> user = userService
				.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Articles> todaysArticles = articleService.findByTimeOfPublish(LocalDate.now());

		model.addAttribute("articles", todaysArticles);
		model.addAttribute("user", user);
		return "/deleteArticles";
	}

	@PostMapping("/deleteSearch")
	public String Search(ModelMap model, @RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "date", required = false) String date) {

		Optional<EndUser> user = userService
				.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Articles> searchArticles = new ArrayList<>();
		if (date.isEmpty()) {
			searchArticles = articleService.findByTimeOfPublish(LocalDate.now());

		} else {
			searchArticles = articleService.findByTimeOfPublish(LocalDate.parse(date));
		}
		;

		searchArticles = searchArticles.stream()
				.filter(s -> s.getCategory().getName().equalsIgnoreCase(search) || s.getTitle().contains(search))
				.collect(Collectors.toList());

		model.addAttribute("articles", searchArticles);
		model.addAttribute("user", user);

		return "deleteArticles";

	}

	@GetMapping("/deleteArticle/{articleId}")
	public String delete(@PathVariable int articleId) {
		
		articleService.deleteArticle(articleId);

		return "redirect:/deleteArticles";
	}
	
	
	@GetMapping("/createUsers")
	public String createUsers(ModelMap model) {
		Optional<EndUser> user = userService
				.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		
		List <Role> roles = roleService.findAllRoles();
		
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		return "createUsers";
	}
	
	
	@PostMapping("/createUsers")
	public String registerSubmit(ModelMap model, @RequestParam String username, String password, String roles) {
		Optional<EndUser> userFromDatabase = userService.findByUsername(username);
		if (userFromDatabase.isPresent()) {
			model.addAttribute("message", "This user name already exists");
			return "createUsers";
		}
		
		EndUser user = new EndUser();
		user.setUsername(username);
		user.setRole(roleService.findByRoleName(roles));
		user.setPassword(encoder.encode(password));
		userService.save(user);
		
		
		return "redirect:/home";
	}
	
	
	

}




