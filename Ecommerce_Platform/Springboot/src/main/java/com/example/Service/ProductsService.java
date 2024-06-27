package com.example.Service;

import java.util.List;

import com.example.Entity.Admin;
import com.example.Entity.Products;

public interface ProductsService {
	
	List<Products> getAllProducts();
    Products getProduct(Long id);
    Products addProduct(Products product);
    List<Products> findByAdmin(Admin admin);
    Products updateProduct(Products product);
    void deleteProduct(Long id);
   
}

