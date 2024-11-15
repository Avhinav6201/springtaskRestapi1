package com.prodapt.practice_project.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prodapt.practice_project.Repository.UserRepo;
import com.prodapt.practice_project.Entity.Product;
import com.prodapt.practice_project.Entity.User;
import com.prodapt.practice_project.Repository.ProductRepo;
@Service
public class UserService {
	  @Autowired
	    private UserRepo userRepository;

	    @Autowired
	    private ProductRepo productRepository;
        public List<User> getAllUser(){
        	return userRepository.findAll();
        	
        }
        public List<Product> getAllProducts(){
        	return productRepository.findAll();
        	
        }
        public Product getProductById(Long id){
        	return productRepository.findById(id).orElse(null);
        	
        }
       
        public User getUserById(Long id){
        	return userRepository.findById(id).orElse(null);
        	
        }
        public boolean deleteProduct(long id) {
            if (productRepository.existsById(id)) {
                productRepository.deleteById(id);
                return true;
            }
            return false;
        }
        public boolean deleteUser(long id) {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return true;
            }
            return false;
        }
        public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }
	    public User createUser(User user) {
	        return userRepository.save(user);
	    }
         public User updateUser(User userDetails,Long id) {
        	 return userRepository.findById(id).map(user->{
        		user.setu_name(userDetails.getUsername());
        		user.setAddress(userDetails.getAddress());
        		user.setProducts(userDetails.getProducts());
        		return userRepository.save(user);
        		 
        	 }).orElse(null);
         }
         public Product updateProduct(Long id, Product productDetails) {
             return productRepository.findById(id).map(product -> {
                 product.setProduct_name(productDetails.getProduct_name());
                 product.setProduct_price(productDetails.getProduct_price());
                 
                 // Update other fields as necessary
                 return productRepository.save(product);
             }).orElse(null);  // Return null if product not found, or you could throw an exception
         }
     
         
	    public Product addProductToUser(Long userId, Product product) {
	        Optional<User> user = userRepository.findById(userId);
	        if (user.isPresent()) {
	            product.setUser(user.get());
	            return productRepository.save(product);
	        } else {
	            throw new RuntimeException("User not found");
	        }
	    }
    
	    public List<Product> getProductsByUserId(Long userId) {
	        return userRepository.findById(userId).orElseThrow().getProducts();
	    }
	    

}
