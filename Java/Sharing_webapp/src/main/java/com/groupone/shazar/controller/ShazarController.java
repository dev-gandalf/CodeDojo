package com.groupone.shazar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.groupone.shazar.service.ProductService;



@Controller
public class ShazarController {
	private ProductService productService;


	@Autowired
	public ShazarController(ProductService productService, UserDetailsService userService) {

		this.productService = productService;

	}



	@GetMapping("/index")
	public String goToIndex() {

		return "index";
	}

}
