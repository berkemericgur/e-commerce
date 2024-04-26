package com.bmg.ecommercedemo.dataaccess.abstracts;

import com.bmg.ecommercedemo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    Category deleteCategoryById(int id);
    Category getCategoryById(int id);
}
