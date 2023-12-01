package com.egustore.eshop.controller;


import com.egustore.eshop.dto.TopSoldReportDTO;
import com.egustore.eshop.service.TopSoldReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v0/top-sold")
@Validated
@CrossOrigin("*")
public class TopSoldReportController {
    private final TopSoldReportService topSoldReportService;

    @Autowired
    public TopSoldReportController(TopSoldReportService topSoldReportService) {
        this.topSoldReportService = topSoldReportService;
    }

    @GetMapping("")
    public ResponseEntity<List<TopSoldReportDTO>> getDefaultTopSoldReport() {
        return ResponseEntity.ok(topSoldReportService.getTopSoldReport());
    }


}
