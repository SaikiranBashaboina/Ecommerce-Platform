package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Admin;
import com.example.Entity.Products;
import com.example.Repo.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products getProduct(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    @Override
    public Products addProduct(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public List<Products> findByAdmin(Admin admin) {
        return productsRepository.findByAdmin(admin);
    }

    @Override
    public Products updateProduct(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
}
