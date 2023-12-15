package com.egustore.eshop.service;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.model.Category;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    Category getCategoryById(int id);
    Category updateCategory(int id, CategoryDTO category);
    List<Category> getAllCategories();
    List<Category> getActiveCategories();

    Category createThumbImage(int Id, MultipartFile files) throws IOException;

    void deleteCategory(int id);
}
