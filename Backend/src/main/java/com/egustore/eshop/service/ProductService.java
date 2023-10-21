package com.egustore.eshop.service;


import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDTO ProductDTO);

    Product getProductById(int id);

    List<Product> getAllProducts();

    Product updateProduct(int id,
                          ProductDTO ProductDTO);

    void deleteProduct(int id);
}
