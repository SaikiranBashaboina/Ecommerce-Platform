package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Admin;
import com.example.Entity.Products;
import com.example.Entity.User;
import com.example.Entity.Userorders;
import com.example.Service.UserordersService;

@CrossOrigin
@RestController
@RequestMapping("/userorders")
public class UserOrdersController {

    @Autowired
    private UserordersService userOrdersService;
    
    @GetMapping("/orders/{adminId}")
    public List<Userorders> getOrdersByAdminId(@PathVariable("adminId") long adminId){
    	Admin admin=new Admin();
    	admin.setAdminid(adminId);
 	   return this.userOrdersService.findByAdmin(admin);
    }
    
    @GetMapping("/myorders/{userId}")
    public List<Userorders> getOrders(@PathVariable("userId") long userId){
         User user=new User();
    	user.setUserid(userId);
 	   return this.userOrdersService.findByUser(user);
    }
}

