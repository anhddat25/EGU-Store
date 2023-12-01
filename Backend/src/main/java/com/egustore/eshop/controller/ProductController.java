package com.egustore.eshop.controller;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Category;
import com.egustore.eshop.model.Product;
import com.egustore.eshop.service.CategoryService;
import com.egustore.eshop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v0/products")
@Validated
@CrossOrigin("*")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //Create category
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductDTO productDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }

        productService.createProduct(productDTO);

        return ResponseEntity.ok("Create Product successfully!");
    }

    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> product = productService.getAllProducts();
        return ResponseEntity.ok(product);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestBody ProductDTO productDTO) {
//        productService.updateProduct(id,productDTO);
//        return ResponseEntity.ok("update product ");
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("delete Product " + id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProductById(@RequestBody ProductDTO productDTO,@PathVariable int id) {
        productService.updateProductById(id, productDTO);
        return ResponseEntity.ok("update Product " + id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable int categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return productService.getProductsByCategory(category);

    }

    @PutMapping("image/{id}")
    public ResponseEntity<String> createThumbImageById(@RequestParam("thumbImage") MultipartFile files,@PathVariable int id) throws IOException {
        productService.createThumbImage(id, files);
        return ResponseEntity.ok("create thumb product image " + id);
    }

    @GetMapping("/top")
    public ResponseEntity<List<Product>> getTopProduct() {
        List<Product> product = productService.getTopProduct();
        return ResponseEntity.ok(product);
    }

}
