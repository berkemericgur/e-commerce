package com.bmg.ecommercedemo.business.abstracts;

import com.bmg.ecommercedemo.business.dtos.request.categoryRequests.CreateCategoryRequest;
import com.bmg.ecommercedemo.business.dtos.request.categoryRequests.UpdateCategoryRequest;
import com.bmg.ecommercedemo.business.dtos.response.categoryResponses.GetAllCategoryResponse;
import com.bmg.ecommercedemo.entity.Category;

import java.util.List;

public interface CategoryService {

    List<GetAllCategoryResponse> getAllCategories();
    Category getCategoryById(int id);
    void addCategories(CreateCategoryRequest createCategoryRequest);
    void updateCategories(UpdateCategoryRequest updateCategoryRequest);
    void deleteCategories(int id);
}
