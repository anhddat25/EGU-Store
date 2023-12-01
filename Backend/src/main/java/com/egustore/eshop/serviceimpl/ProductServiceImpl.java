package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.mapper.ProductMapper;
import com.egustore.eshop.model.Category;
import com.egustore.eshop.model.Product;
import com.egustore.eshop.repository.CategoryRepository;
import com.egustore.eshop.repository.ProductRepository;
import com.egustore.eshop.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private  final CategoryRepository categoryRepository;

    private final GoogleDriveApiService googleDriveApiService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository, GoogleDriveApiService googleDriveApiService)
    {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
        this.googleDriveApiService = googleDriveApiService;
    }

//    @Override
//    public Product createProduct(ProductDTO productDTO, MultipartFile files) throws IOException {
//        String folderId = "1b9O_g-17GkjpCNeRtJG0wwRNhRTNcnEE";
//        String imageUrl = googleDriveApiService.uploadImageToGoogleDrive(files, folderId);
//
//        Product product = productMapper.mapToProduct(productDTO);
//        productDTO.setThumbImage(imageUrl);
//        return productRepository.save(product);
//    }
@Override
public List<Product> getProductsByCategory(Category category) {
    return productRepository.findByCategory(category);
}
    @Override
    public Product updateProductStock(ProductDTO productDTO){
        Product product = productRepository.findById(productDTO.getId()).orElseThrow(() -> new IllegalArgumentException("Voucher code does not exist"));
        product.setStockQuantity(product.getStockQuantity()-productDTO.getStockQuantity());
        return productRepository.save(product);
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
    public Product createThumbImage(int Id, MultipartFile files) throws IOException {
        Optional<Product> existingProduct = productRepository.findById(Id);

        if (existingProduct.isPresent()) {
            // Update the image in Google Drive
            String folderId = "1b9O_g-17GkjpCNeRtJG0wwRNhRTNcnEE";
            String imageUrl = googleDriveApiService.uploadImageToGoogleDrive(files, folderId);

            // Update the image URL in the database
            Product existingEntity = existingProduct.get();
            existingEntity.setThumbnail(imageUrl);
            return productRepository.save(existingEntity);
        } else {
            // Handle the case where the entity with the given ID does not exist
            throw new EntityNotFoundException("Entity with ID " + Id + " not found");
        }
    }

    @Override
    public List<Product>getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProductById(int id,ProductDTO productDTO) {
        Product existProduct = getProductById(id);
        productMapper.updateProductFromDTO(productDTO, existProduct);
        productRepository.save(existProduct);
        return existProduct;
    }

    @Override
    public void deleteProduct(int id) {

        productRepository.deleteById(id);
    }

//    @Override
//    public Integer updateProductById(ProductDTO productDTO, int id) {
//
//        return productRepository.updateProductById(productDTO, id);
//    }

    @Override
    public List<Product>getTopProduct() {
        return productRepository.getTopProduct();
    }
}
