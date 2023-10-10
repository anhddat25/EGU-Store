package com.egustore.eshop.controller;

import com.egustore.eshop.dto.FeedbackProductDTO;
import com.egustore.eshop.model.FeedbackProduct;
import com.egustore.eshop.service.FeedbackProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/feedbacks")
@Validated
public class FeedbackController {

    private final FeedbackProductService  feedbackProductService;

    public FeedbackController(FeedbackProductService feedbackProductService) {
        this.feedbackProductService = feedbackProductService;
    }

    @GetMapping("")
    public ResponseEntity<List<FeedbackProduct>> getAllFeedback(){
        List<FeedbackProduct> feedbacks = feedbackProductService.getAllFeedback();
        return ResponseEntity.ok(feedbacks);
    }


    @GetMapping("/{productId}")
    public ResponseEntity<List<FeedbackProduct>> getFeedbackByProductId(@PathVariable int productId){
        List<FeedbackProduct> feedbacks = feedbackProductService.getFeedbackByProductId(productId);
        return ResponseEntity.ok(feedbacks);
    }

    @PostMapping("")
    public ResponseEntity<String> createFeedback(@RequestBody @Valid FeedbackProductDTO feedbackProductDTO){
        feedbackProductService.createFeedback(feedbackProductDTO);
        return ResponseEntity.ok("Create Success");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFeedback(@PathVariable int id, @RequestBody FeedbackProductDTO feedbackProductDTO){
        feedbackProductService.updateFeedback(id,feedbackProductDTO);
                return ResponseEntity.ok("Update Success "+id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable int id){
        feedbackProductService.deleteFeedback(id);
      return ResponseEntity.ok("delete Success "+id);
    }

}
