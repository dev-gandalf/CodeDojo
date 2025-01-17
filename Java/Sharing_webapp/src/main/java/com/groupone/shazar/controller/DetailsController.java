package com.groupone.shazar.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupone.shazar.model.Product;
import com.groupone.shazar.model.User;
import com.groupone.shazar.security.DefaultUserDetailsService;
import com.groupone.shazar.security.UserPrincipal;
import com.groupone.shazar.service.ProductService;
import com.groupone.shazar.service.UserService;
import com.groupone.shazar.service.UserServiceImpl;

@Controller
public class DetailsController {

	private ProductService productService;


	@Autowired
	public DetailsController(ProductService productService, UserDetailsService userService) {

		this.productService = productService;

	}

	@GetMapping("/details/{productId}")
	public String goToDetails(ModelMap model, @PathVariable int productId) {
		Product productDetail = productService.findByProductId(productId);
		
		User userDetail = new User();
		userDetail.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		userDetail.getUsername();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = dateFormat.format(date);
		model.addAttribute("product", productDetail);
		model.addAttribute("user", userDetail);
		model.addAttribute("today", today);
		return "details"; 
	}
	
	@PostMapping("/details/{productId}")
	public String SendRequest(ModelMap model, @PathVariable int productId, @RequestParam java.sql.Date startDate, @RequestParam java.sql.Date endDate) {
		User userDetail = new User();
		userDetail.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		userDetail.getUsername();
		model.addAttribute("user", userDetail);
		model.addAttribute("product", productService.bookProduct(productId, startDate, endDate));
		return "details";
		
		
	}
	
	@PostMapping("/details/no/{productId}")
	public String SendRequest(ModelMap model, @PathVariable int productId) {
	
		User userDetail = new User();
		userDetail.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		userDetail.getUsername();
		model.addAttribute("product", productService.denyProduct(productId, null));
		model.addAttribute("user", userDetail);
		model.addAttribute("rejected", "You have rejected this request");
		return "details";
		}

	


}