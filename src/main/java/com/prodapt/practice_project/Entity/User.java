package com.prodapt.practice_project.Entity;

import java.util.ArrayList;
import java.util.*;

import jakarta.persistence.*;

@Entity
public class User{
	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   long user_id;
String u_name;
String Address;


public long getUser_id() {
	return user_id;
}
public void setUser_id(long user_id) {
	this.user_id = user_id;
}
public String getUsername() {
	return u_name;
}
public void setu_name(String u_name) {
	this.u_name = u_name;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
List<Product>Products=new ArrayList<Product>();
public List<Product> getProducts() {
	return Products;
}
public void setProducts(List<Product> Products) {
	this.Products = Products;
}


}
