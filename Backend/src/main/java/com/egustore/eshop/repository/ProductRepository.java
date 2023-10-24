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
            "p.stockQuantity = :#{#productDTO.stockQuantity}, " +
            "p.description = :#{#productDTO.description}," +
            "p.discountPercentage = :#{#productDTO.discountPercentage}, " +
            "p.discountPrice = :#{#productDTO.discountPrice}, " +
            "p.status = :#{#productDTO.status}, " +
            "p.category_id = :#{#productDTO.category_id}, " +
            "p.brand_id = :#{#productDTO.brand_id}, " +
            "p.origins_id = :#{#productDTO.origins_id} " +
            "WHERE p.Id = :id")
    Integer updateProductById(@Param("productDTO") ProductDTO productDTO, @Param("id") int id);
    @Modifying
    @Transactional
    @Query  ("INSERT INTO Product p" +
            "(p.name,"+
                    "p.model," +
                    "p.price," +
                    "p.stockQuantity," +
                    "p.description," +
                    "p.discountPercentage," +
                    "p.discountPrice," +
                    "p.status," +
                    "p.category_id," +
                    "p.brand_id," +
                    "p.origins_id)"+
            "VALUES " +
            "   (:#{#productDTO.name}, " +
            "   :#{#productDTO.model}, " +
            "    :#{#productDTO.price}, " +
            "    :#{#productDTO.stockQuantity}, " +
            "    :#{#productDTO.description}, " +
            "   	:#{#productDTO.discountPercentage}, " +
            "   	:#{#productDTO.discountPrice}, " +
            "    :#{#productDTO.status}, " +
            "    :#{#productDTO.category_id}, " +
            "    :#{#productDTO.brand_id}, " +
            "    :#{#productDTO.origins_id})")
    Integer createQuerryProduct(@Param("productDTO") ProductDTO productDTO);
}
