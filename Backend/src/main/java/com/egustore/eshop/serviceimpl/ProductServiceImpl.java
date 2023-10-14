package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.mapper.ProductMapper;
import com.egustore.eshop.model.Product;
import com.egustore.eshop.repository.ProductRepository;
import com.egustore.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper)
    {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = productMapper.mapToProduct(productDTO);
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(int id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }



    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(int id,ProductDTO productDTO) {
        Product existProduct = getProductById(id);
        productMapper.updateProductFromDTO(productDTO, existProduct);
        productRepository.save(existProduct);
        return existProduct;
    }

    @Override
    public void deleteProduct(int id) {

        productRepository.deleteById(id);
    }
}
