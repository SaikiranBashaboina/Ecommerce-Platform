package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    
    private String name;
    
    private double price;
    
	private String description;
    
    private String imageUrl;
    
    @ManyToOne
    @JoinColumn(name = "adminid", referencedColumnName = "adminid")
    private Admin admin;

    
    @Override
	public String toString() {
		return "Products [productId=" + productId + ", name=" + name + ", price=" + price + ", description="
				+ description + ", imageUrl=" + imageUrl + ", admin=" + admin + "]";
	}

	public Products(Long productId, String name, double price, String description, String imageUrl, Admin admin) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUrl = imageUrl;
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(Long productId, String name, double price, String description, String imageUrl) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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
	

}
