package com.bmg.ecommercedemo.business.abstracts;

import com.bmg.ecommercedemo.business.dtos.request.productRequests.CreateProductRequest;
import com.bmg.ecommercedemo.business.dtos.request.productRequests.UpdateProductRequest;
import com.bmg.ecommercedemo.business.dtos.response.productResponses.GetAllProductResponse;
import com.bmg.ecommercedemo.entity.Product;

import java.util.List;

public interface ProductService {
    List<GetAllProductResponse> getAll();
    List<GetAllProductResponse> findByName(String name);
    List<GetAllProductResponse> findByCost(int cost);
    List<GetAllProductResponse> getProductById (long id);
    void addProduct(CreateProductRequest createProductRequest);
    void updateProduct(UpdateProductRequest updateProductRequest);
    void deleteProduct(long id) throws Exception;
}
