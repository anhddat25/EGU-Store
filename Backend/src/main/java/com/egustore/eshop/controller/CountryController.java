package com.egustore.eshop.controller;

import com.egustore.eshop.dto.CountryDTO;
import com.egustore.eshop.model.Country;
import com.egustore.eshop.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/countries")
@Validated
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    //Create category
    @PostMapping("/create")
    public ResponseEntity<?> createCountry(@RequestBody @Valid CountryDTO countryDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        countryService.createCountry(countryDTO);
        return ResponseEntity.ok("Create country successfully!");
    }

    //    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Country>> getAllCountrys() {
        List<Country> countrys = countryService.getAllCountrys();
        return ResponseEntity.ok(countrys);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCountry(@PathVariable int id,@RequestBody CountryDTO countryDTO) {
        countryService.updateCountry(id,countryDTO);
        return ResponseEntity.ok("update country ");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable int id) {
        countryService.deleteCountry(id);
        return ResponseEntity.ok("delete country " + id);
    }

}
