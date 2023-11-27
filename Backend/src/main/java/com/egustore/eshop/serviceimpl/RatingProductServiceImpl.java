package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.RatingProductDTO;
import com.egustore.eshop.mapper.RatingProductMapper;
import com.egustore.eshop.model.FeedbackProduct;
import com.egustore.eshop.model.RatingProduct;
import com.egustore.eshop.repository.RatingProductRepository;
import com.egustore.eshop.service.RatingProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingProductServiceImpl implements RatingProductService {

    private final RatingProductRepository ratingProductRepository;
    private final RatingProductMapper ratingProductMapper;

    public RatingProductServiceImpl(RatingProductRepository ratingProductRepository, RatingProductMapper ratingProductMapper) {
        this.ratingProductRepository = ratingProductRepository;
        this.ratingProductMapper = ratingProductMapper;
    }


    @Override
    public RatingProduct createRating(RatingProductDTO ratingProductDTO) {
        RatingProduct ratingProduct = ratingProductMapper.mapToEntity(ratingProductDTO);
        return ratingProductRepository.save(ratingProduct);
    }

    @Override
    public RatingProduct updateRating(int id, RatingProductDTO ratingProductDTO) {
        Optional<RatingProduct> ratingProductOpt = ratingProductRepository.findById(id);

        ratingProductOpt.ifPresent(ratingProduct -> {
            ratingProductMapper.updateRatingFromDTO(ratingProductDTO, ratingProduct);
            ratingProductRepository.save(ratingProduct);
        });

        return ratingProductOpt.orElseThrow(() -> new RuntimeException("Rating not found"));
    }

    @Override
    public List<RatingProduct> getRatingByProductId(int productId) {
        return ratingProductRepository.getRatingProductByProductId(productId);
    }
    @Override
    public RatingProduct getRatingByCustomerId(int productId,int customerId) {
        return ratingProductRepository.findByProductsIdAndCustomersId(productId,customerId);
    }
    @Override
    public List<RatingProduct> getAllRatingProducts() {
        return ratingProductRepository.findAll();
    }

    @Override
    public void deleteRatingProduct(int id) {
        ratingProductRepository.deleteById(id);
    }
}
  