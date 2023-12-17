package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.mapper.CategoryMapper;
import com.egustore.eshop.model.Category;
import com.egustore.eshop.model.Product;
import com.egustore.eshop.repository.CategoryRepository;
import com.egustore.eshop.repository.ProductRepository;
import com.egustore.eshop.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final GoogleDriveApiService googleDriveApiService;
    private final ProductRepository productRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper, GoogleDriveApiService googleDriveApiService, ProductRepository productRepository)
    {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.googleDriveApiService = googleDriveApiService;
        this.productRepository = productRepository;
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.mapToCategory(categoryDTO);
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(int id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }



    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(int id, CategoryDTO categoryDTO) {
        Category existCategory = getCategoryById(id);
        categoryMapper.updateCategoryFromDTO(categoryDTO, existCategory);
        categoryRepository.save(existCategory);
        return existCategory;
    }

    @Override
    public List<Category> getActiveCategories() {
        return categoryRepository.getActiveCategories();
    }

    @Override
    public Category createThumbImage(int Id, MultipartFile files) throws IOException {
        Optional<Category> existingProduct = categoryRepository.findById(Id);

        if (existingProduct.isPresent()) {
            // Update the image in Google Drive
            String folderId = "1b9O_g-17GkjpCNeRtJG0wwRNhRTNcnEE";
            String imageUrl = googleDriveApiService.uploadImageToGoogleDrive(files, folderId);

            // Update the image URL in the database
            Category existingEntity = existingProduct.get();
            existingEntity.setThumbnail(imageUrl);
            return categoryRepository.save(existingEntity);
        } else {
            // Handle the case where the entity with the given ID does not exist
            throw new EntityNotFoundException("Entity with ID " + Id + " not found");
        }
    }
    @Override
    @Transactional
    public void deleteCategory(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            List<Product> products = category.getProducts();

            for (Product product : products) {
                product.setCategory(product.getCategory() == category ? null : product.getCategory());
            }
            productRepository.saveAll(products);
            categoryRepository.delete(category);
        }
    }
}
