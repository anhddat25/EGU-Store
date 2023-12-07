package com.egustore.eshop.controller;


import com.egustore.eshop.dto.CategoryReportDTO;
import com.egustore.eshop.dto.TopSoldReportDTO;
import com.egustore.eshop.service.CategoryReportService;
import com.egustore.eshop.service.TopSoldReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/top-sold")
@Validated
@CrossOrigin("*")
public class TopSoldReportController {
    private final TopSoldReportService topSoldReportService;

    private final CategoryReportService categoryReportService;

    @Autowired
    public TopSoldReportController(TopSoldReportService topSoldReportService, CategoryReportService categoryReportService) {
        this.topSoldReportService = topSoldReportService;
        this.categoryReportService = categoryReportService;
    }

    @GetMapping("")
    public ResponseEntity<List<TopSoldReportDTO>> getDefaultTopSoldReport() {
        return ResponseEntity.ok(topSoldReportService.getTopSoldReport());
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryReportDTO>> getDefaultCategoryQuantityReport() {
        return ResponseEntity.ok(categoryReportService.getCategoryQuantityReport());
    }
}
