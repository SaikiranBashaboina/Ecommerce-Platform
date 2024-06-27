package com.example.Service;

import java.util.List;

import com.example.Entity.Admin;
import com.example.Entity.Products;
import com.example.Entity.User;
import com.example.Entity.Userorders;

public interface UserordersService {

	List<Userorders> findByUser(User user);
    List<Userorders> findByProduct(Products product);
    List<Userorders> getUserOrders(User user);
    void cancelOrder(Long orderId);
    Userorders saveOrder(Userorders order);

    List<Userorders> findByAdmin(Admin admin);

    Userorders getOrderById(Long orderId);

    void updateOrderStatus(Long orderId, String status);

}

