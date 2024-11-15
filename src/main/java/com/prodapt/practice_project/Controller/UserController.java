package com.prodapt.practice_project.Controller;

import com.prodapt.practice_project.Service.UserService;
import com.prodapt.practice_project.Entity.Product;
import com.prodapt.practice_project.Entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id); 
    }

    // Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return userService.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id) {
        return userService.getProductById(id);
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ? "User deleted successfully" : "User not found";
    }

    // Delete product by ID
    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        boolean deleted = userService.deleteProduct(id);
        return deleted ? "Product deleted successfully" : "Product not found";
    }

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Create a new product
    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {
        return userService.createProduct(product);
    }

    // Update a user by ID
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(userDetails, id);
    }

    // Update a product by ID
    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return userService.updateProduct(id, productDetails);
    }

    // Add a product to a user
    @PostMapping("/{userId}/product")
    public Product addProductToUser(@PathVariable Long userId, @RequestBody Product product) {
        return userService.addProductToUser(userId, product);
    }

    
    @GetMapping("/{userId}/products")
    public List<Product> getProductsByUserId(@PathVariable Long userId) {
        return userService.getProductsByUserId(userId);
    }
}
