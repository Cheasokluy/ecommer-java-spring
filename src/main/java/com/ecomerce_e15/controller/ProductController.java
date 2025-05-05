package com.ecomerce_e15.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce_e15.entity.Category;
import com.ecomerce_e15.entity.Product;
import com.ecomerce_e15.service.CategoryService;
import com.ecomerce_e15.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping("/product")
	public List<Product> getCategoryList() {
		return service.getProducts();
	}
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product item) {
		service.addProduct(item);
		return item;
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable Long id) {
		
		return service.deleteProduct(id);
	}
	
	@PutMapping("/product/{id}")
	public String putMethodName(@PathVariable Long id, @RequestBody Product item) {
		
		return service.updateProduct(id, item);
	}
	

}
