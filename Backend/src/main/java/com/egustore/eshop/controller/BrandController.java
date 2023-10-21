package com.egustore.eshop.controller;

import com.egustore.eshop.dto.BrandDTO;
import com.egustore.eshop.model.Brand;
import com.egustore.eshop.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/brands")
@Validated
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    //Create category
    @PostMapping("/create")
    public ResponseEntity<?> createBrand(@RequestBody @Valid BrandDTO brandDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        brandService.createBrand(brandDTO);
        return ResponseEntity.ok("Create brand successfully!");
    }

    //    //Show all categories
    @GetMapping("/list")
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brands = brandService.getAllBrands();
        return ResponseEntity.ok(brands);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBrand(@PathVariable int id,@RequestBody BrandDTO brandDTO) {
        brandService.updateBrand(id,brandDTO);
        return ResponseEntity.ok("update brand ");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable int id) {
        brandService.deleteBrand(id);
        return ResponseEntity.ok("delete brand " + id);
    }

}
