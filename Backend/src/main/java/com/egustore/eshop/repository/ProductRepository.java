package com.egustore.eshop.repository;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query (value = "UPDATE Product p SET p.name = :#{#productDTO.name}, " +
            "p.model = :#{#productDTO.model}, " +
            "p.price = :#{#productDTO.price}, " +
            "p.thumbImage = :#{#productDTO.thumbImage}, " +
            "p.stockQuantity = :#{#productDTO.stockQuantity}, " +
            "p.description = :#{#productDTO.description}," +
            "p.discountPercentage = :#{#productDTO.discountPercentage}, " +
            "p.discountPrice = :#{#productDTO.discountPrice}, " +
            "p.status = :#{#productDTO.status}, " +
            "p.categoryId = :#{#productDTO.categoryId}, " +
            "p.brandId = :#{#productDTO.brandId}, " +
            "p.originId = :#{#productDTO.originId} " +
            "WHERE p.Id = :id")
    Integer updateProductById(@Param("productDTO") ProductDTO productDTO, @Param("id") int id);
}
