package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Admin;
import com.example.Entity.Products;
import com.example.Entity.User;
import com.example.Entity.Userorders;
import com.example.Repo.AdminRepository;
import com.example.Repo.ProductsRepository;
import com.example.Repo.UserordersRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
    

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Products> getAdminProducts(Admin admin) {
        return productsRepository.findByAdmin(admin);
    }

    @Override
    public Products addProduct(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public Products editProduct(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public List<Products> deleteProduct(Long productId) {
        productsRepository.deleteById(productId);
        return productsRepository.findAll();
    }


	@Override
	public Admin getById(Long id) {
		
		Optional<Admin> opt=adminRepository.findById(id);
		return opt.get();
	}
}