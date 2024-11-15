package com.prodapt.practice_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.practice_project.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository <Product,Long>{

}
