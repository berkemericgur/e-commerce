package com.bmg.ecommercedemo.dataaccess.abstracts;

import com.bmg.ecommercedemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);
    List<Product> findByCost(int productCost);
    List<Product> getProductById(long id);
}
