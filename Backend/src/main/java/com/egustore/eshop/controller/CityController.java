package com.egustore.eshop.controller;

import com.egustore.eshop.dto.CityDTO;
import com.egustore.eshop.model.City;
import com.egustore.eshop.service.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/cities")
@Validated
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    //Create category
    @PostMapping("/create")
    public ResponseEntity<?> createCity(@RequestBody @Valid CityDTO cityDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        cityService.createCity(cityDTO);
        return ResponseEntity.ok("Create city successfully!");
    }

    //    //Show all categories
    @GetMapping("/list")
    public ResponseEntity<List<City>> getAllCitys() {
        List<City> citys = cityService.getAllCitys();
        return ResponseEntity.ok(citys);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCity(@PathVariable int id,@RequestBody CityDTO cityDTO) {
        cityService.updateCity(id,cityDTO);
        return ResponseEntity.ok("update city ");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable int id) {
        cityService.deleteCity(id);
        return ResponseEntity.ok("delete city " + id);
    }

}
