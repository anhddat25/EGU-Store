package com.egustore.eshop.repository;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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


    boolean existsByName(String name);
    Page<Product> findAll(Pageable pageable);


    @Query (value ="SELECT p.* ,SUM(od.quantity) AS total_ordered_quantity FROM Products p JOIN  OrderDetails od ON p.id = od.product_id GROUP BY p.id ORDER BY total_ordered_quantity DESC LIMIT 8;", nativeQuery = true)
    List<Product> getTopProduct();
}
