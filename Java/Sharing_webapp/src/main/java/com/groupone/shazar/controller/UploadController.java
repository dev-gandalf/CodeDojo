package com.groupone.shazar.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.groupone.shazar.model.Picture;
import com.groupone.shazar.model.Product;
import com.groupone.shazar.service.CategoryService;
import com.groupone.shazar.service.ProductService;

@Controller
public class UploadController {

	private ProductService productService;
	private CategoryService categoryService;


	@Autowired
	public UploadController(ProductService productService, UserDetailsService userService, CategoryService categoryService) {

		this.productService = productService;
		this.categoryService = categoryService;
	}

	@GetMapping("/upload")
	public String goToUpload(ModelMap model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "upload";
	}

	@PostMapping("/upload")

	public String pictureUpload(ModelMap model, @RequestParam MultipartFile[] file, String keyword, String product,
			String description,

			Double price) {

		InputStream inputStream;

		Product otherProduct = new Product(description, product, keyword, price);


		List<Picture> pictures = new ArrayList<>();

		for (int i = 0; i < file.length; i++) {

			Picture picture = new Picture(file[i].getOriginalFilename());

			pictures.add(picture);

			Path destinationFile = Paths.get(System.getProperty("user.dir"), "src/main/webapp/product-pictures",

					file[i].getOriginalFilename());

			try {
				inputStream = file[i].getInputStream();
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				model.addAttribute("confirmation", "Could not upload file");
				e.printStackTrace();
				return "upload";
			}

		}

		otherProduct.setPictures(pictures);

		otherProduct.setOwnerUsername(SecurityContextHolder.getContext().getAuthentication().getName());

		productService.saveProduct(otherProduct);

		model.addAttribute("confirmation", "File successfully uploaded");

		return "upload";

	}
}

