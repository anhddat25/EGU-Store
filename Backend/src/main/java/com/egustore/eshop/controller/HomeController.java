package com.egustore.eshop.controller;


import com.egustore.eshop.dto.HomeDTO;
import com.egustore.eshop.service.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v0/home")
@Validated
@CrossOrigin("*")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }
    @GetMapping("")
    public ResponseEntity<List<HomeDTO>> getAllListWithRating() {
        return ResponseEntity.ok(homeService.getAllListWithRating());
    }
}
