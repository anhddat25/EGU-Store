package com.egustore.eshop.controller;

import com.egustore.eshop.dto.AddVoucherDTO;
import com.egustore.eshop.dto.VoucherDTO;
import com.egustore.eshop.model.Voucher;
import com.egustore.eshop.service.VoucherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @Autowired
    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @PostMapping("/create-voucher")
    public ResponseEntity<String> createVoucher(@RequestBody @Valid VoucherDTO voucherDTO) {
        voucherService.createVoucher(voucherDTO);
        return ResponseEntity.ok("Create discount code successfully");
    }
    @GetMapping("/myVoucher/{customerId}")
    public ResponseEntity<List<Voucher>> getActiveVouchersForCustomer(@PathVariable int customerId) {
        List<Voucher> vouchers =  voucherService.getActiveVouchersForCustomer(customerId);
        return ResponseEntity.ok(vouchers);
    }
    @PutMapping("/addToMyVoucher")
    public ResponseEntity<String> addMyVoucher(@RequestBody AddVoucherDTO addVoucherDTO) {
        try {
            voucherService.addMyVoucher(addVoucherDTO);
            return ResponseEntity.ok("Add discount code successfully");
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
            return ResponseEntity.ok("Update status successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
