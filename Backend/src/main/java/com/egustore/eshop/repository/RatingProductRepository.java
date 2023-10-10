package com.egustore.eshop.repository;

import com.egustore.eshop.model.RatingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingProductRepository extends JpaRepository<RatingProduct, Integer> {
    // Các phương thức truy vấn tùy chọn có thể được thêm vào đây nếu cần
    List<RatingProduct> getRatingProductByProductId(int productId);
}