package com.egustore.eshop.controller;

import com.egustore.eshop.dto.RatingProductDTO;
import com.egustore.eshop.model.RatingProduct;
import com.egustore.eshop.response.*;
import com.egustore.eshop.service.RatingProductService;
import com.egustore.eshop.utils.LocalizationUtils;
import com.egustore.eshop.utils.MessageKeys;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v0/rating-products")
@Validated
@CrossOrigin("*")
public class RatingProductController {

    private final RatingProductService ratingProductService;
    private final LocalizationUtils localizationUtils;

    public RatingProductController(RatingProductService ratingProductService, LocalizationUtils localizationUtils) {
        this.ratingProductService = ratingProductService;
        this.localizationUtils = localizationUtils;
    }


    @GetMapping("")
    public ResponseEntity<List<RatingProduct>> getAllRating(){
        List<RatingProduct> rates = ratingProductService.getAllRatingProducts();
        return ResponseEntity.ok(rates);
    }


    @GetMapping("/{productId}")
    public ResponseEntity<List<RatingProduct>> getRatingByProductId(@PathVariable int productId){
        List<RatingProduct> rates = ratingProductService.getRatingByProductId(productId);
        return ResponseEntity.ok(rates);
    }

    @GetMapping("/total/{productId}")
    public ResponseEntity<?> getRatingTotalByProductId(@PathVariable int productId){
        Integer rates = ratingProductService.getRatingTotalByProductId(productId);
        return ResponseEntity.ok(rates);
    }
    @GetMapping("/my-rating")
    public ResponseEntity<RatingProduct> getFeedbackByCustomerId(@RequestParam int productId,@RequestParam int customerId){
        RatingProduct rates = ratingProductService.getRatingByCustomerId(productId,customerId);
        return ResponseEntity.ok(rates);
    }
    @PostMapping("")
    public ResponseEntity<CreateRatingResponse> createRating(@RequestBody @Valid RatingProductDTO ratingProductDTO){
        ratingProductService.createRating(ratingProductDTO);
        return ResponseEntity.ok(CreateRatingResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.RATING_SUCCESSFULLY)).build());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateRatingResponse> updateRating(@PathVariable int id, @RequestBody RatingProductDTO ratingProductDTO){
        ratingProductService.updateRating(id,ratingProductDTO);
        return ResponseEntity.ok(UpdateRatingResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATERATING_SUCCESSFULLY)).build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteRatingResponse> deleteRating(@PathVariable int id){
        ratingProductService.deleteRatingProduct(id);
        return ResponseEntity.ok(DeleteRatingResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETERATING_SUCCESSFULLY)).build());
    }

}