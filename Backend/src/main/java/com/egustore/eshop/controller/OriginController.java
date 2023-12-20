package com.egustore.eshop.controller;

import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.model.Origin;
import com.egustore.eshop.service.OriginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/origins")
@Validated
@CrossOrigin("*")
public class OriginController {
    private final OriginService originService;

    @Autowired
    public OriginController(OriginService originService) {
        this.originService = originService;
    }
    //Create images
    @PostMapping("")
    public ResponseEntity<?> createOrigins(@RequestBody @Valid OriginDTO originDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        originService.createOrigin(originDTO);
        return ResponseEntity.ok("Create origin successfully!");
    }

    //Show all image
    @GetMapping("")
    public ResponseEntity<List<Origin>> getAllOrigins() {
        List<Origin> origins = originService.getAllOrigins();
        return ResponseEntity.ok(origins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Origin> getOriginById(@PathVariable int id) {
        return ResponseEntity.ok(originService.getOriginById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrigins(@PathVariable int id,@RequestBody OriginDTO originDTO) {
        originService.updateOrigins(id,originDTO);
        return ResponseEntity.ok("update origin ");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrigins(@PathVariable int id) {
        originService.deleteOrigins(id);
        return ResponseEntity.ok("delete origin " + id);
    }
}
