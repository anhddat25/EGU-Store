package com.egustore.eshop.controller;

import com.egustore.eshop.dto.CustomerReportDTO;
import com.egustore.eshop.enums.CustomerStatus;
import com.egustore.eshop.service.CustomerReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v0/customer-reports")
@Validated
@CrossOrigin("*")
public class CustomerReportController {
    private final CustomerReportService customerReportService;

    public CustomerReportController(CustomerReportService customerReportService) {
        this.customerReportService = customerReportService;
    }

    @GetMapping("/all-list")
    public ResponseEntity<List<CustomerReportDTO>> getAllCustomerReport() {
        return ResponseEntity.ok(customerReportService.getAllCustomerReport());
    }
    @GetMapping("/buying-list")
    public ResponseEntity<List<CustomerReportDTO>> getBuyingCustomerReport() {
        return ResponseEntity.ok(customerReportService.getBuyingCustomerReport());
    }
    @GetMapping("/none-buying-list")
    public ResponseEntity<List<CustomerReportDTO>> getNoneBuyingCustomerReport() {
        return ResponseEntity.ok(customerReportService.getNoneBuyingCustomerReport());
    }
    @GetMapping("/status")
    public ResponseEntity<CustomerStatus> getStatusReport() {
        CustomerStatus status = CustomerStatus.ACTIVE;
        return ResponseEntity.ok(status);
    }
}
