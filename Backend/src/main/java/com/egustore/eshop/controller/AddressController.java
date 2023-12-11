package com.egustore.eshop.controller;

import com.egustore.eshop.dto.AddressDTO;
import com.egustore.eshop.model.Address;
import com.egustore.eshop.response.CreateAddressResponse;
import com.egustore.eshop.response.DeleteAddressResponse;
import com.egustore.eshop.response.UpdateAddressResponse;
import com.egustore.eshop.service.AddressService;
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
@RequestMapping("api/v0/address")
@Validated
public class AddressController {
    private final AddressService addressService;
    private final LocalizationUtils localizationUtils;

    @Autowired
    public AddressController(AddressService addressService, MessageSource messageSource, LocaleResolver request, LocaleResolver localeResolver, LocalizationUtils localizationUtils) {
        this.addressService = addressService;
        this.localizationUtils = localizationUtils;
    }
    //Create category
    @PostMapping("/create")
    public ResponseEntity<?> createAddress(@RequestBody @Valid AddressDTO addressDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        addressService.createAddress(addressDTO);
        return ResponseEntity.ok(CreateAddressResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.CREATEADDRESS_SUCCESSFULLY)).build());
    }

    //    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Address>> getAllAddress() {
        List<Address> address = addressService.getAllAddress();
        return ResponseEntity.ok(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable int id,@RequestBody AddressDTO addressDTO) {
        addressService.updateAddress(id,addressDTO);
        return ResponseEntity.ok(UpdateAddressResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATEADDRESS_SUCCESSFULLY)).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok(DeleteAddressResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETEADDRESS_SUCCESSFULLY)).build());
    }



}
