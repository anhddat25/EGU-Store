package com.egustore.eshop.service;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Brand;
import com.egustore.eshop.model.Category;
import com.egustore.eshop.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    Product createProduct(ProductDTO productDTO);

//    Product createProduct(ProductDTO productDTO, MultipartFile files) throws IOException;
    Product updateProductStock(ProductDTO productDTO);
    Product getProductById(int id);
    Product updateProductById(int id, ProductDTO Product);

    Product createThumbImage(int Id, MultipartFile files) throws IOException;

    List<Product> getAllProducts();
    void deleteProduct(int id);

//    Integer updateProductById(ProductDTO productDTO, int id);

    List<Product>getTopProduct();

    List<Product> getProductsByCategory(Category category);

    List<Product> getProductsByBrand(Brand brand);
}
