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
public class EditorController {
	
	@Autowired ArticleService articleService;
	@Autowired DefaultUserDetailsService userService;
	@Autowired CategoryService categoryService;
	@Autowired DataService dataService;
		
	
	
	
	

@GetMapping("/review/needsEdit/{articleId}")
public String sendToReviewEdited(@PathVariable int articleId) {
	
	articleService.updateNeedsEdit(articleId);
	
	return "redirect:/myReviewArticles";
}







@GetMapping("/reviewArticles")
public String reviewArticles(ModelMap model) {
	Optional<EndUser> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	model.addAttribute("user", user);
	
	List<Articles> reviewArticles = articleService.findByInReview(true);
	model.addAttribute("reviewArticles", reviewArticles);
	
	return "/reviewArticles";
}



@GetMapping("/selectArticle/{articleId}")
public String selectArticle(@PathVariable int articleId) {
	EndUser editor = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
	Articles getArticleById = articleService.findArticleById(articleId);
	getArticleById.setEditor(editor);
	articleService.saveArticle(getArticleById);
	return "redirect:/reviewArticles";
	
}

@GetMapping("/myReviewArticles")
public String myReviewArticles(ModelMap model) {
	EndUser editor = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
	List<Articles> findByEditor = articleService.findByEditor(editor);
	model.addAttribute("myReviewArticles", findByEditor);
	Optional<EndUser> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	model.addAttribute("user", user);
	
	return "/myReviewArticles";
	
}



@PostMapping("/publish")
public String publishArticle(@RequestParam int articleId, String headlines) {
	
	boolean checkHeadlines;
	
	if(headlines == null) {
		checkHeadlines = false;
	}else { checkHeadlines = true;}
		
	
	
	articleService.publishArticle(articleId, checkHeadlines);
	
	
	return "redirect:/myReviewArticles";
}


	
	
	

}
