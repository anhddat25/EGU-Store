package com.egustore.eshop.service;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.dto.FeedbackProductDTO;
import com.egustore.eshop.model.Category;
import com.egustore.eshop.model.FeedbackProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedbackProductService {
    FeedbackProduct createFeedback(FeedbackProductDTO feedbackProductDTO);
    List<FeedbackProduct> getFeedbackByProductId(int productId);
    List<FeedbackProduct> getFeedbackByCustomerId(int customerId);

    FeedbackProduct updateFeedback(int id , FeedbackProductDTO feedbackProductDTO);
    List<FeedbackProduct> getAllFeedback();
    void deleteFeedback(int id);
}
