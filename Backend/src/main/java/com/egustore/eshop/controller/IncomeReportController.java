package com.egustore.eshop.controller;


import com.egustore.eshop.dto.IncomeReportDTO;
import com.egustore.eshop.model.IncomeReport;
import com.egustore.eshop.service.IncomeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

//    @GetMapping(value = "/byTime")
    @RequestMapping(value = "/byTime", method = RequestMethod.GET)
    public ResponseEntity<List<IncomeReportDTO>> getAllOrderDetails(
            @RequestParam(name = "from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
            @RequestParam(name = "to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date to
    ) {
        return ResponseEntity.ok(incomeReportService.getAllIncomeReportByTime(from, to));
//        try {
//            if (from != null || to != null) {
//                return ResponseEntity.ok(incomeReportService.getAllIncomeReportByTime(from, to));
//            } else {
//                System.out.println("du lieu null");
//                return ResponseEntity.badRequest().body("Dữ liệu không hợp lệ: from hoặc to là null");
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body("Dữ liệu không hợp lệ: from hoặc to là null" + e);
//        }
    }
}
