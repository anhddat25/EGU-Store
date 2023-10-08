package com.egustore.eshop.service;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    Category getCategoryById(int id);
    Category updateCategory(int id, CategoryDTO category);
    List<Category> getAllCategories();
    void deleteCategory(int id);
}
