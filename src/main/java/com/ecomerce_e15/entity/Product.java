package com.ecomerce_e15.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long productId;

    
    private String productName;

    
    private String description;

    private Integer quantity;

    private BigDecimal price;

    private BigDecimal special_price;

    private BigDecimal discount;

    private String image;

    // Relationship: Many products belong to one category
    @ManyToOne
    private Category category;

}
