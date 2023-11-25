package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.mapper.CategoryMapper;
import com.egustore.eshop.model.Category;
import com.egustore.eshop.repository.CategoryRepository;
import com.egustore.eshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper)
    {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.mapToCategory(categoryDTO);
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(int id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }



    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(int id, CategoryDTO categoryDTO) {
        Category existCategory = getCategoryById(id);
        categoryMapper.updateCategoryFromDTO(categoryDTO, existCategory);
        categoryRepository.save(existCategory);
        return existCategory;
    }

    @Override
    public List<Category> getActiveCategories() {
        return categoryRepository.getActiveCategories();
    }




    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
