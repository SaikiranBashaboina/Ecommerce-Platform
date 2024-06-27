package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Userorders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;
    
    private String name;
    
	private double price;
    
    private String description;
    
    private String imageUrl;
    
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Products product;

    @ManyToOne
    @JoinColumn(name = "adminid", referencedColumnName = "adminid")
    private Admin admin;
    
    private String status; // New field

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Userorders [orderid=" + orderid + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", imageUrl=" + imageUrl + ", user=" + user + ", product=" + product + ", admin=" + admin
				+ ", status=" + status + "]";
	}

	public Userorders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userorders(Long orderid, String name, double price, String description, String imageUrl, User user,
			Products product, Admin admin, String status) {
		super();
		this.orderid = orderid;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUrl = imageUrl;
		this.user = user;
		this.product = product;
		this.admin = admin;
		this.status = status;
	}


	



}
