package com.prodapt.practice_project.Entity;

import jakarta.persistence.*;

@Entity
public class Product {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	long p_id;
     String product_name;
     float product_price;
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "user_id")  // The foreign key in the Product table
     private User user;

	@Override
	public String toString() {
		return "product [id=" + p_id + ", product_name=" + product_name + ", product_price=" + product_price + "]";
	}
	public long getId() {
		return p_id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
