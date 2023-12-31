package com.egustore.eshop.repository;

import com.egustore.eshop.model.RatingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RatingProductRepository extends JpaRepository<RatingProduct, Integer> {
    // Các phương thức truy vấn tùy chọn có thể được thêm vào đây nếu cần

    @Query(value = "Select * From egu_store.rating_products r where r.product_id = :productId", nativeQuery = true)
    List<RatingProduct> getRatingProductByProductId(@Param("productId") int productId);

    @Query(value = "Select SUM(r.rating) as total_rating From egu_store.rating_products r where r.product_id = :productId", nativeQuery = true)
    Integer getRatingTotalByProductId(@Param("productId") int productId);


    RatingProduct findByProductsIdAndCustomersId(int productId,int customerId);
}
