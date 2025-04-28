package com.ecomerce_e15.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce_e15.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
