package com.ecomerce_e15.serviceImpl;

import java.awt.event.ItemEvent;
import java.util.List;
import org.modelmapper.ModelMapper;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecomerce_e15.entity.Category;
import com.ecomerce_e15.repository.CategoryRepository;
import com.ecomerce_e15.service.CategoryService;

import DTO.BaseDTO;
import DTO.CategoryDTO;
import DTO.CategoryListDTO;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository repo;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public ResponseEntity<BaseDTO<CategoryListDTO>> getCategory() {
		List<CategoryDTO> list = repo.findAll().stream().map(item -> modelMapper.map(item, CategoryDTO.class))
				.collect(Collectors.toList());

		CategoryListDTO categoryListDTO = new CategoryListDTO(list);
		BaseDTO<CategoryListDTO> response = new BaseDTO<>(HttpStatus.OK.value(), "", categoryListDTO);

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<BaseDTO<CategoryDTO>> addCategory(Category item) {
		repo.save(item);
		CategoryDTO itemDto = modelMapper.map(item, CategoryDTO.class);
		BaseDTO<CategoryDTO> responseBaseDTO = new BaseDTO<>(HttpStatus.OK.value(),"",itemDto);
		return new ResponseEntity<BaseDTO<CategoryDTO>>(responseBaseDTO,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<BaseDTO<CategoryDTO>> deleteCategory(Long id) {
		Optional<Category> item = repo.findById(id);
		if (item.isPresent()) {
			repo.delete(item.get());
			CategoryDTO itemDto = modelMapper.map(item.get(), CategoryDTO.class);
			BaseDTO<CategoryDTO> response = new BaseDTO<>(HttpStatus.OK.value(),"",itemDto);
			return ResponseEntity.ok(response);
			
		}
		BaseDTO<CategoryDTO> response = new BaseDTO<>(HttpStatus.BAD_REQUEST.value(), "Item does not exist", null);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@Override
	public ResponseEntity<BaseDTO<CategoryDTO>> updateCategory(Category itemForzUpdate, Long id) {
		Optional<Category> existingItemOptional = repo.findById(id);
		
		if (existingItemOptional.isPresent()) {
			existingItemOptional.get().setName(itemForzUpdate.getName());
			repo.save(existingItemOptional.get());
			CategoryDTO itemDto = modelMapper.map(existingItemOptional.get(), CategoryDTO.class);
			BaseDTO<CategoryDTO> repsonseBaseDTO = new BaseDTO<>(HttpStatus.OK.value(),"",itemDto);
			return ResponseEntity.ok(repsonseBaseDTO);

			
		}
		
		BaseDTO<CategoryDTO> responseBaseDTO = new BaseDTO<>(HttpStatus.BAD_REQUEST.value(),"item dosent exist",null);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBaseDTO);
	}

	

}
