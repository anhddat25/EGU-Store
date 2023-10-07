package com.egustore.eshop.controller;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.entity.OrderDetail;
import com.egustore.eshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    //Create Order
    @PostMapping("/order-detail")
    public ResponseEntity<OrderDetail> createOrder(@RequestBody OrderDetailDTO orderDetailDTO) {
        return ResponseEntity.ok(orderDetailService.saveOrder(orderDetailDTO));
    }

    @GetMapping("/orders-detail")
    public ResponseEntity<List<OrderDetailDTO>> getAllCategories() {
        return ResponseEntity.ok(orderDetailService.getOrderDetailList());
    }

    @PutMapping("/order-detail/{id}")
    public ResponseEntity<OrderDetailDTO> updateOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderDetailService.getOrderDetailById(id));
    }
}
