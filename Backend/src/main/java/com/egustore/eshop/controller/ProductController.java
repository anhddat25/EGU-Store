package com.egustore.eshop.controller;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Product;
import com.egustore.eshop.response.*;
import com.egustore.eshop.service.ProductService;
import com.egustore.eshop.utils.LocalizationUtils;
import com.egustore.eshop.utils.MessageKeys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final LocalizationUtils localizationUtils;
    @Autowired
    public ProductController(ProductService productService, LocalizationUtils localizationUtils) {
        this.productService = productService;
        this.localizationUtils = localizationUtils;
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

        return ResponseEntity.ok(CreateProductResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.PRODUCT_SUCCESSFULLY)).build());
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

    @PutMapping("/stock-quantity")
    public ResponseEntity<UpdateProductStockResponse> updateProductStock(@RequestBody ProductDTO productDTO){
        productService.updateProductStock(productDTO);
        return ResponseEntity.ok(UpdateProductStockResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATE_PRODUCT_STOCK_SUCCESSFULLY)).build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteProductResponse> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(DeleteProductResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETE_PRODUCT_SUCCESSFULLY)).build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateProductResponse> updateProductById(@RequestBody ProductDTO productDTO,@PathVariable int id) {
        productService.updateProductById(id, productDTO);
        return ResponseEntity.ok(UpdateProductResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATE_RODUCT_SUCCESSFULLY)).build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @PutMapping("image/{id}")
    public ResponseEntity<UpdateProductImageResponse> createThumbImageById(@RequestParam("thumbImage") MultipartFile files,@PathVariable int id) throws IOException {
        productService.createThumbImage(id, files);
        return ResponseEntity.ok(UpdateProductImageResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATE_PRODUCT_IMAGE_SUCCESSFULLY)).build());
    }

    @GetMapping("/top")
    public ResponseEntity<List<Product>> getTopProduct() {
        List<Product> product = productService.getTopProduct();
        return ResponseEntity.ok(product);
    }

}
