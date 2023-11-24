package com.egustore.eshop.service;

import com.egustore.eshop.dto.RatingProductDTO;
import com.egustore.eshop.model.RatingProduct;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingProductService {
    RatingProduct createRating(RatingProductDTO ratingProductDTO);
//    List<RatingProduct> getRatingByProductId(int productId);
//    List<RatingProduct> getRatingByCustomerId(int customerId);
    RatingProduct updateRating(int id , RatingProductDTO ratingProductDTO);
    List<RatingProduct> getAllRatingProducts();
    void deleteRatingProduct(int id);
}