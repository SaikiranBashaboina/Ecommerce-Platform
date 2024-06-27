package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Products;
import com.example.Service.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

//    @GetMapping("/")
//    public List<Products> getAllProducts() {
//        return productsService.getAllProducts();
//    }
//
//    @GetMapping("/{id}")
//    public Products getProduct(@PathVariable Long id) {
//        return productsService.getProduct(id);
//    }
//
//    @PostMapping("/")
//    public Products addProduct(@RequestBody Products product) {
//        return productsService.addProduct(product);
//    }
}