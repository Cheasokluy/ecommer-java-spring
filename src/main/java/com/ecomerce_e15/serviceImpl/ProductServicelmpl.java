package com.ecomerce_e15.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce_e15.entity.Category;
import com.ecomerce_e15.entity.Product;
import com.ecomerce_e15.repository.ProductRepository;
import com.ecomerce_e15.service.ProductService;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServicelmpl implements ProductService {

	@Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }


    @Override
    public Product addProduct(Product product) {
    	productRepo.save(product);
        return product;
    }

    @Override
    public String updateProduct(Long id, Product product) {
    	
        Optional<Product>  existingProduct = productRepo.findById(id);
        
        if (existingProduct.isPresent()) {
        	 existingProduct.get().setProductName(product.getProductName());
        	 existingProduct.get().setDescription(product.getDescription());
             existingProduct.get().setPrice(product.getPrice());
             existingProduct.get().setSpecial_price(product.getSpecial_price());
             existingProduct.get().setDiscount(product.getDiscount());
             existingProduct.get().setImage(product.getImage());
             existingProduct.get().setQuantity(product.getQuantity());
             existingProduct.get().setCategory(product.getCategory());
			productRepo.save(existingProduct.get());
			return "Update success...";
		}
		return "Item does not exist";
    }

    @Override
    public String deleteProduct(Long id) {
    	
    	Optional<Product> item = productRepo.findById(id);
		
		if (item.isPresent()) {
			productRepo.deleteById(id);
			return "Delete success...";
		}
		
		return "Item does not exist";
    }
}
