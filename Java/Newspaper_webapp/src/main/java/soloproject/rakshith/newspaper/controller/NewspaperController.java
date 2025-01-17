package soloproject.rakshith.newspaper.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import soloproject.rakshith.newspaper.DataService.DataService;
import soloproject.rakshith.newspaper.model.Articles;
import soloproject.rakshith.newspaper.model.Category;
import soloproject.rakshith.newspaper.model.EndUser;
import soloproject.rakshith.newspaper.security.DefaultUserDetailsService;
import soloproject.rakshith.newspaper.service.ArticleService;
import soloproject.rakshith.newspaper.service.CategoryService;

@Controller
public class NewspaperController {
	
@Autowired ArticleService articleService;
@Autowired DefaultUserDetailsService userService;
@Autowired CategoryService categoryService;
@Autowired DataService dataService;
	
	



@GetMapping("/")
	public String startPage() {
	
//	dataService.createUsers();
	
	
//	dataService.createArticles(LocalDate.of(2023, 11, 8));
		
		return "redirect:/index";
	}

@GetMapping("/index")
public String goToIndex(ModelMap model) {
	Optional<EndUser> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	List<Category> userSubscriptions = new ArrayList<>();
	if (user.isPresent()){  userSubscriptions = user.get().getSubscriptions();};
		
	
	List<Category> category = categoryService.getAllCategories();
	
	List<Articles> headlines = articleService.findByTimeOfPublish(LocalDate.now());
	headlines = headlines.stream().filter(h -> h.isHeadlines() == true).collect(Collectors.toList());
	
	model.addAttribute("userSubscriptions", userSubscriptions);
	model.addAttribute("articles", headlines);
	model.addAttribute("category", category);
	model.addAttribute("user", user);
	
	return "index";
}

@GetMapping("/home")
public String goHome(ModelMap model) {
	Optional<EndUser> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	List<Category> userSubscriptions = user.get().getSubscriptions();
	List<Category> category = categoryService.getAllCategories();
	
	List<Articles> subbedArticles = articleService.getArticlesByUserSubscriptions(user.get());
	
	
	model.addAttribute("userSubscriptions", userSubscriptions);
	model.addAttribute("articles", subbedArticles);
	model.addAttribute("category", category);
	model.addAttribute("user", user);
	
	return "index";
}


@GetMapping("/index/{newsCategory}")
public String newsCategory (ModelMap model, @PathVariable String newsCategory) {
	Optional<EndUser> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	List<Category> userSubscriptions = new ArrayList<>();
	if (user.isPresent()){  userSubscriptions = user.get().getSubscriptions();};
		
	
	List<Category> category = categoryService.getAllCategories();
	
	List<Articles> articles = articleService.findByTimeOfPublish(LocalDate.now());
	articles = articles.stream().filter(a -> a.getCategory().getName().equals(newsCategory)).collect(Collectors.toList());
	
	model.addAttribute("userSubscriptions", userSubscriptions);
	model.addAttribute("articles", articles);
	model.addAttribute("category", category);
	model.addAttribute("user", user);
	
			
	
	return "index";
}





@PostMapping("/search")
public String Search(ModelMap model, 
					@RequestParam(value = "search", required=false) String search, 
					@RequestParam (value = "date", required=false)  String date) { 

	Optional<EndUser> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	List<Category> userSubscriptions = new ArrayList<>();
	if (user.isPresent()){  userSubscriptions = user.get().getSubscriptions();};
		
	
	List<Category> category = categoryService.getAllCategories();
	List<Articles> searchArticles = new ArrayList<>();
	if (date.isEmpty()) { searchArticles = articleService.findByTimeOfPublish(LocalDate.now());
		
	} else {searchArticles = articleService.findByTimeOfPublish(LocalDate.parse(date));};
	
	
	searchArticles = searchArticles.stream().filter(s -> s.getCategory().getName().equalsIgnoreCase(search) ||
													     s.getTitle().contains(search)).collect(Collectors.toList());
	
	model.addAttribute("userSubscriptions", userSubscriptions);
	model.addAttribute("articles", searchArticles);
	model.addAttribute("category", category);
	model.addAttribute("user", user);
	
	return "index";
	
		
	
}





@PostMapping("/subscriptions")
public String selectSubscriptions(@RequestParam(value = "subscriptions", required=false) String[] subscriptions) {
	
	EndUser subscriber = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
	
	if (subscriptions != null) {userService.saveSubscriptions(subscriber, subscriptions); }
	
	
	
	
	return "redirect:/home";
}

@GetMapping("/details/{articleId}")
public String details(ModelMap model, @PathVariable int articleId) {
	Optional<EndUser> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	model.addAttribute("user", user);
	
	Articles articles = articleService.findArticleById(articleId);
	model.addAttribute("articles", articles);
	return "details";
}

}
