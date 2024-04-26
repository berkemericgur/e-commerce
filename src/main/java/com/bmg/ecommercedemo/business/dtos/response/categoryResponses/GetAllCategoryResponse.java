package com.bmg.ecommercedemo.business.dtos.response.categoryResponses;

import com.bmg.ecommercedemo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCategoryResponse {

    private int id;
    private String name;
    private String description;
    private List<Product> products;
}
