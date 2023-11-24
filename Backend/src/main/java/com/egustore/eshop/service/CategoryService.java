package com.egustore.eshop.service;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.enums.CategoryStatus;
import com.egustore.eshop.model.Category;
import com.egustore.eshop.model.Origin;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    Category getCategoryById(int id);
    Category updateCategory(int id, CategoryDTO category);
    List<Category> getAllCategories();
    List<Category> getActiveCategories();
    void deleteCategory(int id);
}
