package com.egustore.eshop.controller;

import com.egustore.eshop.dto.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class OrderController {
    @GetMapping("")
    public ResponseEntity<String> getAllCategories() {
        return ResponseEntity.ok("All Order");
    }

    //Create Order
    @PostMapping("")
    public ResponseEntity<String> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok("create Order" + orderDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable int id) {
        return ResponseEntity.ok("update Order " +id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        return ResponseEntity.ok("delete Order " + id);
    }
}
