package soloproject.rakshith.newspaper.controller;

import java.util.List;
import java.util.Optional;

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
import soloproject.rakshith.newspaper.model.EndUser;
import soloproject.rakshith.newspaper.security.DefaultUserDetailsService;
import soloproject.rakshith.newspaper.service.ArticleService;
import soloproject.rakshith.newspaper.service.CategoryService;

@Controller
public class ContributorController {

	@Autowired ArticleService articleService;
	@Autowired DefaultUserDetailsService userService;
	@Autowired CategoryService categoryService;
	@Autowired DataService dataService;
	
	
	







@GetMapping("/myArticles")
public String goToMyArticles(ModelMap model) {
	Optional<EndUser> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	model.addAttribute("user", user);
	
	EndUser contributor = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
	List <Articles> myArticles = articleService.findByContributor(contributor);
	model.addAttribute("myArticles", myArticles);
	
	return "myArticles";
}




@PostMapping("/createArticle")

public String createArticle(@RequestParam String category, String title) {
	
	EndUser contributor = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
	Articles newArticle = articleService.newArticle(category, title);
	newArticle.setContributor(contributor);
	articleService.saveArticle(newArticle);

	
	return "redirect:/myArticles";
}



@GetMapping("/edit/{articleId}")
public String goToEdit(@PathVariable int articleId, ModelMap model) {
	
	Optional<EndUser> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	Articles getArticleById = articleService.findArticleById(articleId);
	model.addAttribute("article", getArticleById);
	model.addAttribute("user", user);
	return "edit";
}



@PostMapping("/edit")
public String saveEdit(@RequestParam int id, String category, String title, String article, ModelMap model) {
	
	Articles updatedArticle = articleService.updateArticle(id, category, title, article);
	
	
	return "redirect:/edit/" + updatedArticle.getId() ;
}




@GetMapping("/review/{articleId}")
public String sendToReview(@PathVariable int articleId) {
	
	articleService.updateReview(articleId);
	
	return "redirect:/myArticles";
}

	
	
}
