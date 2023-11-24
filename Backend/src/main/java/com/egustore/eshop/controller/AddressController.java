package com.egustore.eshop.controller;

import com.egustore.eshop.dto.AddressDTO;
import com.egustore.eshop.model.Address;
import com.egustore.eshop.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/address")
@Validated
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
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
        return ResponseEntity.ok("Create address successfully!");
    }

    //    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Address>> getAllAddress() {
        List<Address> address = addressService.getAllAddress();
        return ResponseEntity.ok(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable int id,@RequestBody AddressDTO addressDTO) {
        addressService.updateAddress(id,addressDTO);
        return ResponseEntity.ok("update address ");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("delete address " + id);
    }



}
