package com.example.Service;

import java.util.List;

import com.example.Entity.Admin;
import com.example.Entity.Products;
import com.example.Entity.User;
import com.example.Entity.Userorders;

public interface AdminService {
	Admin findByEmail(String email);
    Admin saveAdmin(Admin admin);
    List<Products> getAdminProducts(Admin admin);
    Products addProduct(Products product);
    Products editProduct(Products product);
    public List<Products> deleteProduct(Long productId);
    Admin getById(Long id);

}
