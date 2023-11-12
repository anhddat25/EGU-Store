package com.egustore.eshop.controller;

import com.egustore.eshop.dto.FeedbackProductDTO;
import com.egustore.eshop.dto.RatingProductDTO;
import com.egustore.eshop.model.FeedbackProduct;
import com.egustore.eshop.model.RatingProduct;
import com.egustore.eshop.service.RatingProductService;
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

    public RatingProductController(RatingProductService ratingProductService) {
        this.ratingProductService = ratingProductService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<RatingProduct>> getAllRating(){
        List<RatingProduct> rates = ratingProductService.getAllRatingProducts();
        return ResponseEntity.ok(rates);
    }


//    @GetMapping("/{productId}")
//    public ResponseEntity<List<RatingProduct>> getRatingByProductId(@PathVariable int productId){
//        List<RatingProduct> rates = ratingProductService.getRatingByProductId(productId);
//        return ResponseEntity.ok(rates);
//    }

    @PostMapping("/create")
    public ResponseEntity<String> createRating(@RequestBody @Valid RatingProductDTO ratingProductDTO){
        ratingProductService.createRating(ratingProductDTO);
        return ResponseEntity.ok("Create Success");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRating(@PathVariable int id, @RequestBody RatingProductDTO ratingProductDTO){
        ratingProductService.updateRating(id,ratingProductDTO);
        return ResponseEntity.ok("Update Success "+id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable int id){
        ratingProductService.deleteRatingProduct(id);
        return ResponseEntity.ok("delete Success "+id);
    }

}