package com.egustore.eshop.controller;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.model.Category;
import com.egustore.eshop.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/categories")
@Validated
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    //Create category
    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody @Valid  CategoryDTO categoryDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok("Create category successfully!");
    }

    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateCategory(@PathVariable int id,@RequestBody CategoryDTO categoryDTO) {
//        categoryService.updateCategory(id,categoryDTO);
//        return ResponseEntity.ok("update category ");
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("delete category " + id);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Category>> getActiveCategories() {
        List<Category> categories = categoryService.getActiveCategories();
        return ResponseEntity.ok(categories);
    }
}
