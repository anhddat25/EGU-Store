package com.egustore.eshop.controller;


import com.egustore.eshop.dto.IncomeReportDTO;
import com.egustore.eshop.model.OrderDetail;
import com.egustore.eshop.service.IncomeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v0/income-reports")
@Validated
@CrossOrigin("*")
public class IncomeReportController {
    private final IncomeReportService incomeReportService;

    @Autowired
    public IncomeReportController(IncomeReportService incomeReportService) {
        this.incomeReportService = incomeReportService;
    }

    @GetMapping("/default-list")
    public ResponseEntity<List<IncomeReportDTO>> getDefaultIncomeReport() {
        return ResponseEntity.ok(incomeReportService.getDefaultIncomeReport());
    }

    @GetMapping("/byTime")
    public ResponseEntity<List<IncomeReportDTO>> getAllOrderDetails(@RequestParam Date from, @RequestParam Date to) {
        return ResponseEntity.ok(incomeReportService.getAllIncomeReportByTime(from, to));
    }
}
