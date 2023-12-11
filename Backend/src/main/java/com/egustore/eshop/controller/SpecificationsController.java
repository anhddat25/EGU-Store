package com.egustore.eshop.controller;


import com.egustore.eshop.dto.SpecificationsDTO;
import com.egustore.eshop.model.Specifications;
import com.egustore.eshop.response.*;
import com.egustore.eshop.service.SpecificationsService;
import com.egustore.eshop.utils.LocalizationUtils;
import com.egustore.eshop.utils.MessageKeys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/specifications")
@Validated
@CrossOrigin("*")
public class SpecificationsController {
    private final SpecificationsService specificationsService;
    private final LocalizationUtils localizationUtils;

    @Autowired
    public SpecificationsController(SpecificationsService specificationsService, LocalizationUtils localizationUtils) {
        this.specificationsService = specificationsService;
        this.localizationUtils = localizationUtils;
    }
    //Create category
    @PostMapping("")
    public ResponseEntity<?> createSpec(@RequestBody @Valid SpecificationsDTO specificationsDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        specificationsService.createSpec(specificationsDTO);
        return ResponseEntity.ok(CreateSpecificationResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.SPECIFICATION_SUCCESSFULLY)).build());
    }

    //    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Specifications>> getAllPayment() {
        List<Specifications> specifications = specificationsService.getAllSpec();
        return ResponseEntity.ok(specifications);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateSepcificationResponse> updateSpec(@PathVariable int id,@RequestBody SpecificationsDTO specificationsDTO) {
        specificationsService.updateSpec(id,specificationsDTO);
        return ResponseEntity.ok(UpdateSepcificationResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATESPECIFICATION_SUCCESSFULLY)).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteSpecificationResponse> deleteSpec(@PathVariable int id) {
        specificationsService.deleteSpec(id);
        return ResponseEntity.ok(DeleteSpecificationResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETESPECIFICATION_SUCCESSFULLY)).build());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Specifications> getSpecById(@PathVariable int id) {
        return ResponseEntity.ok(specificationsService.getSpecById(id));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Specifications> getByProduct(@PathVariable int id) {
        return ResponseEntity.ok(specificationsService.getByProduct(id));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateProductById(@RequestBody SpecificationsDTO specificationsDTO, @PathVariable int id) {
//        specificationsService.updateSpecById(specificationsDTO, id);
//        return ResponseEntity.ok("update Product " + id);
//    }
}
