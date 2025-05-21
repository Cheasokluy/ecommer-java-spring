package com.ecomerce_e15.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecomerce_e15.entity.Category;

import DTO.BaseDTO;
import DTO.CategoryDTO;
import DTO.CategoryListDTO;

public interface CategoryService {
	ResponseEntity<BaseDTO<CategoryListDTO>> getCategory();
	ResponseEntity<BaseDTO<CategoryDTO>> addCategory(Category item);
	ResponseEntity<BaseDTO<CategoryDTO>> deleteCategory(Long id);
	ResponseEntity<BaseDTO<CategoryDTO>> updateCategory(Category itemForzUpdate, Long id);
	
}
