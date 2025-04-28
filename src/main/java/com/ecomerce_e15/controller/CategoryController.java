package com.ecomerce_e15.controller;

import org.springframework.web.bind.annotation.RestController;
import com.ecomerce_e15.repository.CategoryRepository;
import com.ecomerce_e15.service.CategoryService;
import com.ecomerce_e15.entity.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;
	
	@Autowired
	CategoryService service;

    CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
	
	@GetMapping("/api/category")
	public List<Category> getCategoryList() {
		return service.getCategory();
	}
	
	@PostMapping("/api/category")
	public Category addCategory(@RequestBody Category item) {
		service.addCategory(item);
		return item;
	}
	
}
