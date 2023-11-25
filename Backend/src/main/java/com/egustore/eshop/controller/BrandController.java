package com.egustore.eshop.controller;

import com.egustore.eshop.dto.BrandDTO;
import com.egustore.eshop.model.Brand;
import com.egustore.eshop.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/brands")
@Validated
@CrossOrigin("*")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("")
    public ResponseEntity<List<Brand>> getAllBrands(){
        List<Brand> brands = brandService.getAllBrands();
        return ResponseEntity.ok(brands);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable int id){
        Brand brands = brandService.getBrandById(id);
        return ResponseEntity.ok(brands);
    }

    @PostMapping("")
    public ResponseEntity<String> createBrand(@RequestBody @Valid BrandDTO brandDTO){
        brandService.createBrand(brandDTO);
        return ResponseEntity.ok("Create Success");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBrand(@PathVariable int id, @RequestBody BrandDTO brandDTO){
        brandService.updateBrand(id, brandDTO);
        return ResponseEntity.ok("Update Success "+id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable int id){
        brandService.deleteBrand(id);
        return ResponseEntity.ok("delete Success "+id);
    }

}
