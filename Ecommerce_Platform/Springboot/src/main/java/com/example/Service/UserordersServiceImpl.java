package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Admin;
import com.example.Entity.Products;
import com.example.Entity.User;
import com.example.Entity.Userorders;
import com.example.Repo.UserordersRepository;

@Service
public class UserordersServiceImpl implements UserordersService {

    @Autowired
    private UserordersRepository userordersRepository;

    @Override
    public List<Userorders> findByUser(User user) {
        return userordersRepository.findByUser(user);
    }

    @Override
    public List<Userorders> findByProduct(Products product) {
        return userordersRepository.findByProduct(product);
    }

    @Override
    public List<Userorders> getUserOrders(User user) {
        return userordersRepository.findByUser(user);
    }

    @Override
    public void cancelOrder(Long orderId) {
        userordersRepository.deleteById(orderId);
    }

	@Override
	public Userorders saveOrder(Userorders order) {
        return userordersRepository.save(order);
    }

	@Override
	public List<Userorders> findByAdmin(Admin admin) {
		
		return userordersRepository.findByAdmin(admin);
	}
	
	@Override
    public void updateOrderStatus(Long orderId, String status) {
        Userorders order = userordersRepository.findByOrderid(orderId);
        if (order != null) {
            order.setStatus(status);
            userordersRepository.save(order);
        }
    }

	@Override
	public Userorders getOrderById(Long orderId) {
		
		return userordersRepository.findByOrderid(orderId);
	}
    
    
}
