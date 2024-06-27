package com.example.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Admin;
import com.example.Entity.Products;
import com.example.Entity.User;
import com.example.Entity.Userorders;
import com.example.Service.AdminService;
import com.example.Service.ProductsService;
import com.example.Service.UserordersService; // Import ProductsService

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private UserordersService userordersService;
    
    @PostMapping("/login")
    public Long login(@RequestBody Admin admin) {
    	Admin databaseAdmin=adminService.findByEmail(admin.getEmail());
    	if(admin!=null) {
    		if(admin.getPassword().equals(databaseAdmin.getPassword())) {
    			System.out.println(databaseAdmin.getAdminid());
    			return databaseAdmin.getAdminid();
    		}
    	}
        return null;
    }
    
   
    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @GetMapping("/products/{id}")
    public List<Products> getAdminProducts(@PathVariable("id") Long adminId) {
    	Admin admin=new Admin();
    	admin.setAdminid(adminId);
        List<Products> product = productsService.findByAdmin(admin);
        for(Products pr:product) {
        System.out.println(pr);
        }
        return  product;
    }

    
    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable("id") long id) {
        return adminService.getById(id);
    }

   @PostMapping("/addproduct/{id}")
    public Products addProduct(@RequestBody Products products,@PathVariable("id") Long adminId) {
	   System.out.println(adminId);
       products.setAdmin(adminService.getById(adminId));
       return adminService.addProduct(products);
    }
   @GetMapping("/product/{productId}")
   public Products getProductById(@PathVariable("productId") Long productId) {
       return productsService.getProduct(productId);
   }

   @PutMapping("/product/{productId}")
   public Products updateProduct(@PathVariable("productId") Long productId, @RequestBody Products product) {
       Products existingProduct = productsService.getProduct(productId);
       if (existingProduct != null) {
           existingProduct.setName(product.getName());
           existingProduct.setPrice(product.getPrice());
           existingProduct.setDescription(product.getDescription());
           existingProduct.setImageUrl(product.getImageUrl());
           return productsService.updateProduct(existingProduct);
       }
       return null;
   }
   
   @DeleteMapping("/product/{productId}")
   public List<Products> deleteProduct(@PathVariable("productId") Long productId) {
       return adminService.deleteProduct(productId);
   }
   
   @PatchMapping("/order/{orderid}/deliver")
   public Userorders deliverOrder(@PathVariable("orderid") Long orderid) {
       userordersService.updateOrderStatus(orderid, "Delivered");
       return userordersService.getOrderById(orderid);
   }

 
}