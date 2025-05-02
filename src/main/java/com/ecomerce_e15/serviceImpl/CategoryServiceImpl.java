package com.ecomerce_e15.serviceImpl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public String deleteCategory(Long id) {
		Optional<Category> item = repo.findById(id);
		
		if (item.isPresent()) {
			repo.delete(item.get());
			return "Delete success...";
		}
		
		return "Item does not exist";
	}

	@Override
	public String updateCategory(Category itemForUpdate, Long id) {
		Optional<Category> existingItem = repo.findById(id);
		
		if (existingItem.isPresent()) {
			existingItem.get().setName(itemForUpdate.getName());
			repo.save(existingItem.get());
			return "Update success...";
		}
		return "Item does not exist";
	}

}
