package com.egustore.eshop.controller;

import com.egustore.eshop.dto.AddVoucherDTO;
import com.egustore.eshop.dto.VoucherDTO;
import com.egustore.eshop.model.Voucher;
import com.egustore.eshop.response.*;
import com.egustore.eshop.service.VoucherService;
import com.egustore.eshop.utils.LocalizationUtils;
import com.egustore.eshop.utils.MessageKeys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0/vouchers")
@Validated
@CrossOrigin("*")
public class VoucherController {

    private final VoucherService voucherService;
    private final LocalizationUtils localizationUtils;

    @Autowired
    public VoucherController(VoucherService voucherService, LocalizationUtils localizationUtils) {
        this.voucherService = voucherService;
        this.localizationUtils = localizationUtils;
    }

    @PostMapping("/create-voucher")
    public ResponseEntity<CreateVoucherResponse> createVoucher(@RequestBody @Valid VoucherDTO voucherDTO) {
        voucherService.createVoucher(voucherDTO);
        return ResponseEntity.ok(CreateVoucherResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.VOUCHER_SUCCESSFULLY)).build());
    }
    @GetMapping("/myVoucher/{customerId}")
    public ResponseEntity<List<Voucher>> getActiveVouchersForCustomer(@PathVariable int customerId) {
        List<Voucher> vouchers =  voucherService.getActiveVouchersForCustomer(customerId);
        return ResponseEntity.ok(vouchers);
    }
    @PutMapping("/addToMyVoucher")
    public ResponseEntity<?> addMyVoucher(@RequestBody AddVoucherDTO addVoucherDTO) {
        try {
            voucherService.addMyVoucher(addVoucherDTO);
            return ResponseEntity.ok(UpdateVoucherResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATEVOUCHER_SUCCESSFULLY)).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/use")
    public ResponseEntity<?> validateVoucher(@RequestParam String codeVoucher, @RequestParam int customerId) {
        try {
            Optional<Voucher> validatedVoucher = voucherService.findByCodeVoucher(codeVoucher, customerId);
            return ResponseEntity.ok(validatedVoucher);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/use/{codeVoucher}")
    public ResponseEntity<?> updateVoucherByCode(@PathVariable String codeVoucher) {
        try {
            voucherService.useMyVoucher(codeVoucher);
            return ResponseEntity.ok(UpdateVoucherStatusResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATE_VOUCHER_STATUS_SUCCESSFULLY)).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
