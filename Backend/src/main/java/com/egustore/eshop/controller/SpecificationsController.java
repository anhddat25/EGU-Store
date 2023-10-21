package com.egustore.eshop.controller;


import com.egustore.eshop.dto.SpecificationsDTO;
import com.egustore.eshop.model.Specifications;
import com.egustore.eshop.service.SpecificationsService;
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

    @Autowired
    public SpecificationsController(SpecificationsService specificationsService) {
        this.specificationsService = specificationsService;
    }
    //Create category
    @PostMapping("/create")
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
        return ResponseEntity.ok("Create Specification successfully!");
    }

    //    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Specifications>> getAllPayment() {
        List<Specifications> specifications = specificationsService.getAllSpec();
        return ResponseEntity.ok(specifications);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSpec(@PathVariable int id,@RequestBody SpecificationsDTO specificationsDTO) {
        specificationsService.updateSpec(id,specificationsDTO);
        return ResponseEntity.ok("update Specifications ");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpec(@PathVariable int id) {
        specificationsService.deleteSpec(id);
        return ResponseEntity.ok("delete Specifications " + id);
}}
