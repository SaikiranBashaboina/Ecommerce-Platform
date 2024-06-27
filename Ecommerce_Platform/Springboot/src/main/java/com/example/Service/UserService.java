package com.example.Service;

import java.util.List;

import com.example.Entity.User;

public interface UserService {
	
	User findByEmail(String email);
    User saveUser(User user);
    User findById(Long userId);
    
    User getbyId(Long id);

}

