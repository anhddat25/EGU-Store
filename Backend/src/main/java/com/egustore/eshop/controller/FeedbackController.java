package com.egustore.eshop.controller;

import com.egustore.eshop.dto.FeedbackProductDTO;
import com.egustore.eshop.model.FeedbackProduct;
import com.egustore.eshop.response.*;
import com.egustore.eshop.service.FeedbackProductService;
import com.egustore.eshop.utils.LocalizationUtils;
import com.egustore.eshop.utils.MessageKeys;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;

@RestController
@RequestMapping("/api/v0/feedbacks")
@Validated
@CrossOrigin("*")
public class FeedbackController {

    private final FeedbackProductService  feedbackProductService;
    private final LocalizationUtils localizationUtils;

    public FeedbackController(FeedbackProductService feedbackProductService, MessageSource messageSource, LocaleResolver request, LocaleResolver localeResolver, LocalizationUtils localizationUtils) {
        this.feedbackProductService = feedbackProductService;
        this.localizationUtils = localizationUtils;
    }

    @GetMapping("/list")
    public ResponseEntity<List<FeedbackProduct>> getAllFeedback(){
        List<FeedbackProduct> feedbacks = feedbackProductService.getAllFeedback();
        return ResponseEntity.ok(feedbacks);
    }


    @GetMapping("/list/{productId}")
    public ResponseEntity<List<FeedbackProduct>> getFeedbackByProductId(@PathVariable int productId){
        List<FeedbackProduct> feedbacks = feedbackProductService.getFeedbackByProductId(productId);
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/my-feedback/{customerId}")
    public ResponseEntity<List<FeedbackProduct>> getFeedbackByCustomerId(@PathVariable int customerId){
        List<FeedbackProduct> feedbacks = feedbackProductService.getFeedbackByCustomerId(customerId);
        return ResponseEntity.ok(feedbacks);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createFeedback(@RequestBody @Valid FeedbackProductDTO feedbackProductDTO, BindingResult result){
        try {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        feedbackProductService.createFeedback(feedbackProductDTO);
        return ResponseEntity.ok(CreateFeedbackResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.CREATEFEEDBACK_SUCCESSFULLY)).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(CreateFeedbackResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.CREATEFEEDBACK_FAILED,e.getMessage())).build());
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFeedback(@PathVariable int id, @RequestBody FeedbackProductDTO feedbackProductDTO){
        try {
        feedbackProductService.updateFeedback(id,feedbackProductDTO);
        return ResponseEntity.ok(UpdateFeedbackResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATEFEEDBACK_SUCCESSFULLY)).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(UpdateFeedbackResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATEFEEDBACK_FAILED,e.getMessage())).build());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable int id){
        try {
        feedbackProductService.deleteFeedback(id);
        return ResponseEntity.ok(DeleteFeedbackResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETEFEEDBACK_SUCCESSFULLY)).build());
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(DeleteFeedbackResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETEFEEDBACK_FAILED,e.getMessage())).build());
    }
    }



}
