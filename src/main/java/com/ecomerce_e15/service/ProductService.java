package com.ecomerce_e15.service;

import java.util.List;

import com.ecomerce_e15.entity.Product;

public interface ProductService {
	List<Product> getProducts();
    Product addProduct(Product product);
    String updateProduct(Long id, Product product);
    String deleteProduct(Long id);

}
