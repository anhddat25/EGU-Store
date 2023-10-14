package com.egustore.eshop.service;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDTO productDTO);
    Product getProductById(int id);
    Product updateProduct(int id, ProductDTO Product);
    List<Product> getAllProduct();
    void deleteProduct(int id);

}
