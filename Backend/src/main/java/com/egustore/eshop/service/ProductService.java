package com.egustore.eshop.service;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDTO productDTO);
    Product getProductById(int id);
    Product updateProduct(int id, ProductDTO Product);
    List<Product> getAllProducts();
    void deleteProduct(int id);

    Integer updateProductById(ProductDTO productDTO, int id);

}
