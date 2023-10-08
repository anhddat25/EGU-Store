package com.egustore.eshop.service;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.model.Category;

import java.util.List;

public interface CategoryService {
//    Category getCategoryById(int id);
//    Category createCategory(CategoryDTO categoryDTO);
    List<Category> getAllCategories();
//    Category updateCategory(int id, CategoryDTO category);
//    void deleteCategory(int id);
}
