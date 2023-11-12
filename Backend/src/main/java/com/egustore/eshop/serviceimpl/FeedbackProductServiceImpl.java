package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.FeedbackProductDTO;
import com.egustore.eshop.mapper.FeedbackProductMapper;
import com.egustore.eshop.model.FeedbackProduct;
import com.egustore.eshop.repository.FeedbackProductRepository;
import com.egustore.eshop.service.FeedbackProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackProductServiceImpl implements FeedbackProductService {


    private final FeedbackProductRepository feedbackProductRepository;
    private final FeedbackProductMapper feedbackProductMapper;
    public FeedbackProductServiceImpl(FeedbackProductRepository feedbackProductRepository, FeedbackProductMapper feedbackProductMapper) {
        this.feedbackProductRepository = feedbackProductRepository;
        this.feedbackProductMapper = feedbackProductMapper;
    }

    @Override
    public FeedbackProduct createFeedback(FeedbackProductDTO feedbackProductDTO) {
        FeedbackProduct feedbackProduct = feedbackProductMapper.mapToEntity(feedbackProductDTO);
        return feedbackProductRepository.save(feedbackProduct);
    }

    @Override
    public List<FeedbackProduct> getFeedbackByProductId(int productId) {
        return feedbackProductRepository.findByProductId(productId);
    }


    @Override
    public FeedbackProduct updateFeedback(int id, FeedbackProductDTO feedbackProductDTO) {
        Optional<FeedbackProduct> feedbackProductOpt = feedbackProductRepository.findById(id);

        feedbackProductOpt.ifPresent(feedbackProduct -> {
            feedbackProductMapper.updateFeedbackFromDTO(feedbackProductDTO, feedbackProduct);
            feedbackProductRepository.save(feedbackProduct);
        });

        return feedbackProductOpt.orElseThrow(() -> new RuntimeException("Feedback not found"));
    }

    @Override
    public List<FeedbackProduct> getAllFeedback() {
        return feedbackProductRepository.findAll();
    }

    @Override
    public void deleteFeedback(int id) {
        feedbackProductRepository.deleteById(id);
    }
}
