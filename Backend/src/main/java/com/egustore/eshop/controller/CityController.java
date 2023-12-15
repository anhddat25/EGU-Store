package com.egustore.eshop.controller;

import com.egustore.eshop.dto.CityDTO;
import com.egustore.eshop.model.City;
import com.egustore.eshop.response.CreateCityResponse;
import com.egustore.eshop.response.CreateFeedbackResponse;
import com.egustore.eshop.response.DeleteCityResponse;
import com.egustore.eshop.response.UpdateCityResponse;
import com.egustore.eshop.service.CityService;
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
@RequestMapping("api/v0/cities")
@Validated
public class CityController {
    private final CityService cityService;
    private final LocalizationUtils localizationUtils;

    @Autowired
    public CityController(CityService cityService, MessageSource messageSource, LocaleResolver request, LocaleResolver localeResolver, LocalizationUtils localizationUtils) {
        this.cityService = cityService;
        this.localizationUtils = localizationUtils;
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
        return ResponseEntity.ok(CreateCityResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.CREATECITY_SUCCESSFULLY)).build());
    }

    //    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<City>> getAllCitys() {
        List<City> citys = cityService.getAllCitys();
        return ResponseEntity.ok(citys);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCity(@PathVariable int id,@RequestBody CityDTO cityDTO) {
        cityService.updateCity(id,cityDTO);
        return ResponseEntity.ok(UpdateCityResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATECITY_SUCCESSFULLY)).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable int id) {
        cityService.deleteCity(id);
        return ResponseEntity.ok(DeleteCityResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETECITY_SUCCESSFULLY)).build());
    }

}
