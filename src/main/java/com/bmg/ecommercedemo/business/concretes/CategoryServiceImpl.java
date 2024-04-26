package com.bmg.ecommercedemo.business.concretes;

import com.bmg.ecommercedemo.business.abstracts.CategoryService;
import com.bmg.ecommercedemo.business.dtos.request.categoryRequests.CreateCategoryRequest;
import com.bmg.ecommercedemo.business.dtos.request.categoryRequests.UpdateCategoryRequest;
import com.bmg.ecommercedemo.business.dtos.response.categoryResponses.GetAllCategoryResponse;
import com.bmg.ecommercedemo.business.mappers.ModelMapperService;
import com.bmg.ecommercedemo.dataaccess.abstracts.CategoryDao;
import com.bmg.ecommercedemo.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCategoryResponse> getAllCategories() {

        List<Category> categories = this.categoryDao.findAll();

        List<GetAllCategoryResponse> categoryResponses = categories.stream()
                .map(category -> modelMapperService.forResponse()
                        .map(category, GetAllCategoryResponse.class))
                .collect(Collectors.toList());

        return categoryResponses;
    }
    @Override
    public Category getCategoryById(int id){

        Category category = this.categoryDao.getCategoryById(id);
        return category;
    }

    @Override
    public void addCategories(CreateCategoryRequest createCategoryRequest) {

        Category category = this.modelMapperService.forRequest()
                .map(createCategoryRequest, Category.class);
        this.categoryDao.save(category);
    }

    @Override
    public void updateCategories(UpdateCategoryRequest updateCategoryRequest) {

        Category category = this.modelMapperService.forRequest()
                .map(updateCategoryRequest, Category.class);
        this.categoryDao.save(category);
    }

    @Override
    public void deleteCategories(int id) {

        Category category = this.categoryDao.deleteCategoryById(id);
        this.categoryDao.save(category);
    }


}
