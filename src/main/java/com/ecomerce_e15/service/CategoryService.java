package com.ecomerce_e15.service;

import java.util.List;

import com.ecomerce_e15.entity.Category;

public interface CategoryService {
	List<Category> getCategory();
	Category addCategory(Category item);
	String deleteCategory(Long id);
	String updateCategory(Category itemForUpdate, Long id);
}
