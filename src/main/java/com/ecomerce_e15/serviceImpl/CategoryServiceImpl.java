package com.ecomerce_e15.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce_e15.entity.Category;
import com.ecomerce_e15.repository.CategoryRepository;
import com.ecomerce_e15.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository repo;

	@Override
	public List<Category> getCategory() {
		
		return repo.findAll();
	}

	@Override
	public Category addCategory(Category item) {
		repo.save(item);
		return item;
	}

}
