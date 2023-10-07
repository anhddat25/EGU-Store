package com.egustore.eshop.controller;

import com.egustore.eshop.dto.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v0/categories")
@Validated
public class CategoryController {
//    //Show all categories
//    @GetMapping("")
//    public ResponseEntity<String> getAllCategories() {
//        return ResponseEntity.ok("All category");
//    }
//
//    //Create category
//    @PostMapping("")
//    public ResponseEntity<String> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
//        return ResponseEntity.ok("create category" + categoryDTO);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateCategory(@PathVariable int id) {
//        return ResponseEntity.ok("update category " +id);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
//        return ResponseEntity.ok("delete category " + id);
//    }
}
