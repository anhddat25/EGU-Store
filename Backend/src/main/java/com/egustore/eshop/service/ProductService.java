package com.egustore.eshop.service;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.Product;
import com.egustore.eshop.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDTO productDTO);
    List<Product> getAllProduct();
    Product getProductById(int id);
    Product updateProduct(int id, ProductDTO Product);
    Page<ProductResponse> getAllProducts(PageRequest pageRequest);
    void deleteProduct(int id);

    Integer updateProductById(ProductDTO productDTO, int id);

}
