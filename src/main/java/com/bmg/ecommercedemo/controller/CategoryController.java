package com.bmg.ecommercedemo.controller;

import com.bmg.ecommercedemo.business.abstracts.CategoryService;
import com.bmg.ecommercedemo.business.dtos.request.categoryRequests.CreateCategoryRequest;
import com.bmg.ecommercedemo.business.dtos.request.categoryRequests.UpdateCategoryRequest;
import com.bmg.ecommercedemo.business.dtos.response.categoryResponses.GetAllCategoryResponse;
import com.bmg.ecommercedemo.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping(value = "/getAll")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public List<GetAllCategoryResponse> getAll(){
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "/api/get/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Category getById(@PathVariable("id") int id){
        return this.categoryService.getCategoryById(id);
    }


    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void add(@RequestBody CreateCategoryRequest createCategoryRequest){
        this.categoryService.addCategories(createCategoryRequest);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest,
                       @PathVariable("id") int id){

        this.categoryService.updateCategories(updateCategoryRequest);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(int id){
        this.categoryService.deleteCategories(id);
    }
}
