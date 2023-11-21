package com.egustore.eshop.service;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Product;
import com.egustore.eshop.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    Product createProduct(ProductDTO productDTO);

//    Product createProduct(ProductDTO productDTO, MultipartFile files) throws IOException;

    Product getProductById(int id);
    Product updateProduct(int id, ProductDTO Product);

    Product createThumbImage(int Id, MultipartFile files) throws IOException;

    List<Product> getAllProducts();
    Page<ProductResponse> getAllProducts(PageRequest pageRequest);
    void deleteProduct(int id);

    Integer updateProductById(ProductDTO productDTO, int id);

    List<Product>getTopProduct();
}
