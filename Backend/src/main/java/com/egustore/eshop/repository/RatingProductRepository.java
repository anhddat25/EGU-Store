package com.egustore.eshop.repository;

import com.egustore.eshop.model.RatingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RatingProductRepository extends JpaRepository<RatingProduct, Integer> {
    // Các phương thức truy vấn tùy chọn có thể được thêm vào đây nếu cần

    @Query(value = "Select * From egu_store.rating_product r where r.product_id = :productId", nativeQuery = true)
    List<RatingProduct> getRatingProductByProductId(@Param("productId") int productId);
//List<RatingProduct> getRatingProductByProductId(int productId);
//    List<RatingProduct> findByCustomerId(int customerId);
@Query(value = "Select * From egu_store.rating_product r where r.customer_id = :customerId", nativeQuery = true)
List<RatingProduct> findByCustomerId(@Param("customerId") int customerId);
}
