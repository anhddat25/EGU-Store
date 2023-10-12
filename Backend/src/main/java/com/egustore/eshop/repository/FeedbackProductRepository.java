package com.egustore.eshop.repository;

import com.egustore.eshop.model.FeedbackProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackProductRepository  extends JpaRepository<FeedbackProduct, Integer> {
//    List<FeedbackProduct> findByProductId(int productId);

    @Query(value = "SELECT f.* FROM Feedback_Product f  WHERE f.product_id = ?", nativeQuery = true)
    List<FeedbackProduct> findByProductId(int productId);
}
