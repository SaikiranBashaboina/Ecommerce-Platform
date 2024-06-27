package com.example.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Admin;
import com.example.Entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	
    List<Products> findByAdmin(Admin admin);
}
