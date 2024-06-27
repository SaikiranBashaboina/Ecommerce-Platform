package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Admin;
import com.example.Entity.Products;
import com.example.Entity.User;
import com.example.Entity.Userorders;
import com.example.Service.ProductsService;
import com.example.Service.UserService;
import com.example.Service.UserordersService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserordersService userordersService;
    
    @Autowired
    private ProductsService productsService;

    @PostMapping("/login")
    public Long login(@RequestBody User user) {
       User dbuser=userService.findByEmail(user.getEmail());
       if(user!=null) {
    	   if(user.getPassword().equals(dbuser.getPassword())){
    		   return dbuser.getUserid();
    	   }
       }
       return null;
    }
    
    @GetMapping("/allproducts/{id}")
    public List<Products> getAllProducts(@PathVariable("id") Long userid) {
    	User user=new User();
    	user.setUserid(userid);
        return productsService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") long id) {
        return userService.getbyId(id);
    }
    
    @PostMapping("/register")
    public User register(@RequestBody User user) {
    	
        return userService.saveUser(user);
    }

    @PostMapping("/order/{id}")
    public Userorders placeOrder(@RequestBody Userorders order,@PathVariable("id") Long id) { 
    	 User user = userService.getbyId(id);
         order.setUser(user);
         Products product = productsService.getProduct(order.getProduct().getProductId());
         order.setProduct(product);
         Admin admin = product.getAdmin();  // Retrieve the admin from the product
         order.setAdmin(admin); 
         order.setStatus("Processing");
         return userordersService.saveOrder(order);
    }
    
    @PatchMapping("/order/{orderid}/cancel")
    public Userorders cancelOrder(@PathVariable("orderid") Long orderid) {
        userordersService.updateOrderStatus(orderid, "Cancelled");
        return userordersService.getOrderById(orderid);
    }

   
}