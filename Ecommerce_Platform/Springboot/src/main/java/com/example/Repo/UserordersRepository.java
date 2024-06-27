package com.example.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Entity.Admin;
import com.example.Entity.Products;
import com.example.Entity.User;
import com.example.Entity.Userorders;

@Repository
public interface UserordersRepository extends JpaRepository<Userorders, Long> {
	
	List<Userorders> findByUser(User user); 
	
	List<Userorders>  findByProduct(Products product);
	
	List<Userorders> findByAdmin(Admin admin);
	
    Userorders findByOrderid(Long orderId);


}
