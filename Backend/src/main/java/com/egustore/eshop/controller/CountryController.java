package com.egustore.eshop.controller;

import com.egustore.eshop.dto.CountryDTO;
import com.egustore.eshop.model.Country;
import com.egustore.eshop.response.CreateCountryResponse;
import com.egustore.eshop.response.DeleteCountryResponse;
import com.egustore.eshop.response.UpdateCountryResponse;
import com.egustore.eshop.service.CountryService;
import com.egustore.eshop.utils.LocalizationUtils;
import com.egustore.eshop.utils.MessageKeys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;

@RestController
@RequestMapping("api/v0/countries")
@Validated
public class CountryController {
    private final CountryService countryService;
    private final LocalizationUtils localizationUtils;

    @Autowired
    public CountryController(CountryService countryService, MessageSource messageSource, LocaleResolver request, LocaleResolver localeResolver, LocalizationUtils localizationUtils) {
        this.countryService = countryService;
        this.localizationUtils = localizationUtils;
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
        return ResponseEntity.ok(CreateCountryResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.CREATECOUNTRY_SUCCESSFULLY)).build());
    }

    //    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Country>> getAllCountrys() {
        List<Country> countrys = countryService.getAllCountrys();
        return ResponseEntity.ok(countrys);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable int id,@RequestBody CountryDTO countryDTO) {
        countryService.updateCountry(id,countryDTO);
        return ResponseEntity.ok(UpdateCountryResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATECOUNTRY_SUCCESSFULLY)).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable int id) {
        countryService.deleteCountry(id);
        return ResponseEntity.ok(DeleteCountryResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETECOUNTRY_SUCCESSFULLY)).build());
    }

}
