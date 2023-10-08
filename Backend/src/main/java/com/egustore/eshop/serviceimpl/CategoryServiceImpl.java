package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.model.Category;
import com.egustore.eshop.repository.CategoryRepository;
import com.egustore.eshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
//    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository
//                               CategoryMapper categoryMapper
    ) {
        this.categoryRepository = categoryRepository;
//        this.categoryMapper = categoryMapper;
    }


//    @Override
//    public Category getCategoryById(int id){
//        return categoryRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Category not found"));
//    }

//    @Override
//    public Category createCategory(CategoryDTO categoryDTO) {
//
////        Category category = categoryMapper.mapToCategory(categoryDTO);
////        return categoryRepository.save(category);
//    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

//    @Override
//    public Category updateCategory(int id, CategoryDTO categoryDTO) {
//        Category existCategory = getCategoryById(id);
//        Category savedCategory = categoryRepository.save(existCategory);
//        return categoryMapper.mapToCategoryDto(savedCategory);
//    }

//    @Override
//    public void deleteCategory(int id) {
//        categoryRepository.deleteById(id);
//    }
}
