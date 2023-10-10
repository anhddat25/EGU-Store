package com.egustore.eshop.service;

import com.egustore.eshop.dto.RatingProductDTO;
import com.egustore.eshop.model.RatingProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingProductService {
    RatingProduct createRating(RatingProductDTO ratingProductDTO);
    List<RatingProduct> getRatingByProductId(int productId);
    RatingProduct updateRating(int id , RatingProductDTO ratingProductDTO);
    List<RatingProduct> getAllRatingProducts();
    void deleteRatingProduct(int id);
}
