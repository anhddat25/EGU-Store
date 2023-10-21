package com.egustore.eshop.controller;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Product;
import com.egustore.eshop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/products")
@Validated
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //Create category
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductDTO productDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
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

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestBody ProductDTO productDTO) {
        productService.updateProduct(id,productDTO);
        return ResponseEntity.ok("update product ");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("delete Product " + id);
    }
}
