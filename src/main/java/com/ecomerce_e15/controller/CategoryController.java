package com.ecomerce_e15.controller;

import org.springframework.web.bind.annotation.RestController;
import com.ecomerce_e15.service.CategoryService;
import com.ecomerce_e15.entity.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api")
public class CategoryController {

	
	@Autowired
	CategoryService service;
	
	@GetMapping("/category")
	public List<Category> getCategoryList() {
		return service.getCategory();
	}
	
	@PostMapping("/category")
	public Category addCategory(@RequestBody Category item) {
		service.addCategory(item);
		return item;
	}
	
	@DeleteMapping("/category/{id}")
	public String deleteCategory(@PathVariable Long id) {
		
		return service.deleteCategory(id);
	}
	
	@PutMapping("/category/{id}")
	public String putMethodName(@PathVariable Long id, @RequestBody Category item) {
		
		return service.updateCategory(item, id);
	}
	
}
